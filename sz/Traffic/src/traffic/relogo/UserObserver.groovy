package traffic.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import traffic.ReLogoObserver;

class UserObserver extends ReLogoObserver{
	def yieldZones = []
	
	@Setup
	def setup(){
		clearAll()
		setDefaultShape(UserTurtle, "car")
		setDefaultShape(Destination, "house")
		
		def width = (UserPatch.laneWidth + 1) / 2
		def d = 15
		yieldZones = []

		[[-1, 0, red()], [1, 0, green()], [0, -1, blue()], [0, 1, yellow()]].eachWithIndex { pos, index ->

			def (x, y, color) = pos
			def sign = (x + y) * width
			def xOffset = -sign * (1 - Math.abs(x))
			def yOffset = sign * (1 - Math.abs(y))

			createPoissonStreams(1) {
				setxy(d * x + xOffset, d * y + yOffset)
				facexy(xOffset, yOffset)
				destinations = [0,1,2,3] - index
				setColor(white())
			}
			
			createYieldZones(1) {
				setxy(UserPatch.laneWidth * 1.7 * x + xOffset, UserPatch.laneWidth * 1.7 * y + yOffset)
				setSize(1)
				setColor(black())
				facexy(xOffset, yOffset)
				yieldZones.add(it)
			}
			
			createDestinations(1) {
				setxy(d * x - xOffset, d * y - yOffset)
				facexy(xOffset, yOffset)
				setColor(color)
				register()
			}
		}
		
		yieldZones[2].yieldsTo = [yieldZones[1]]
		yieldZones[1].yieldsTo = [yieldZones[3]]
		yieldZones[3].yieldsTo = [yieldZones[0]]
		yieldZones[0].yieldsTo = [yieldZones[2]]
		
		ask(patches()) {
			setColor()
		}

		resetTimer()
	}
	
	@Go
	def go(){
		def dt = timer()
		ask(turtles()){
			step(dt)
		}
		checkDeadlock()
		resetTimer()
	}
	
	def checkDeadlock() {
		def isDeadlocked = yieldZones().every { !it.hasRightOfWay() } && userTurtles().every { it.speed == 0 } 

		if (isDeadlocked) {
			println("Deadlock occurred!")
			pause() 
		}
	}
	
	def carsOnTheRoad() {
		count(userTurtles())
	}
	
	def crashRate() {
		return UserTurtle.numCrashes
		def n = numAllCars()
		if (n == 0)
			return 0
		UserTurtle.numCrashes / n
	}
	
	def numAllCars() {
		UserTurtle.numAllCars
	}
	
	def meanTravelTime() {
		def sum = 0
		def count = 0
		ask(destinations()) {
			sum += totalTravelTime
			count += numCarsArrived
		}
		if (count == 0) return 0
		sum / count
	}
	
	def meanTravelTimeN() {
		Destination.instances[3].meanTravelTime()
	}
	
	def meanTravelTimeS() {
		Destination.instances[2].meanTravelTime()
	}
	
	def meanTravelTimeW() {
		Destination.instances[0].meanTravelTime()
	}
	
	def meanTravelTimeE() {
		Destination.instances[1].meanTravelTime()
	}
}
