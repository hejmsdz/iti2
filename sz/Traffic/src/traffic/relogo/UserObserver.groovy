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
	def streams = []
	def lightState = null
	
	@Setup
	def setup(){
		clearAll()
		setDefaultShape(UserTurtle, "car")
		setDefaultShape(Destination, "house")
		setDefaultShape(Roundabout, "x")
		greenHorizontally = true
		
		UserTurtle.numCrashes = 0
		UserTurtle.numAllCars = 0
		ask(destinations()) {
			totalTravelTime = 0
			numCarsArrived = 0
		}
		
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
				streams.add(it)
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
		
		ask(patches()) {
			setColor()
		}
		
		if (intersectionType == "p2pIntersection") {
			yieldZones[2].yieldsTo = [yieldZones[1]]
			yieldZones[1].yieldsTo = [yieldZones[3]]
			yieldZones[3].yieldsTo = [yieldZones[0]]
			yieldZones[0].yieldsTo = [yieldZones[2]]
		} else if (intersectionType == "priority") {
			yieldZones[0].yieldsTo = yieldZones[1].yieldsTo = []
			yieldZones[2].yieldsTo = yieldZones[3].yieldsTo = [yieldZones[0], yieldZones[1]]
		} else if (intersectionType == "roundabout") {
			[
					[-1,  3],[ 0,  3],[ 1,  3],
					[-2,  2],	 	  [ 2,  2],
				[-3,  1],	 	  		  	[ 3,  1],
				[-3,  0], 		  			[ 3,  0],
				[-3, -1], 		  			[ 3, -1],
					[-2, -2], 		  [ 2, -2],
					[ -1,-3],[ 0, -3],[ 1, -3]
			].each{ pos ->
				def (x, y) = pos
				
				createRoundabouts(1) {
					setxy(x, y)
					setSize(1)
					setColor(green())
					register()
				}
			
			}
		}

		resetTimer()
	}
	
	@Go
	def go(){
		def dt = timer()
		ask(turtles()){
			step(dt)
		}
		
		if (intersectionType == "trafficLights") {
			def newLightState = currentLightState()
			if (newLightState != lightState) {
				ask(patches()) {
					changeLights(newLightState)
				}
				lightState = newLightState
			}
		}
		
		checkDeadlock()
		resetTimer()
	}
	
	def currentLightState() {
		def second = Calendar.getInstance().get(Calendar.SECOND) % 20
		if (second < 9) {
			UserPatch.LightState.HORIZONTAL
		} else if (second >= 8 && second < 10 || second >= 18) {
			UserPatch.LightState.INTERMEDIATE
		} else {
			UserPatch.LightState.VERTICAL
		}
	}
	
	def checkDeadlock() {
		def isDeadlocked = userTurtles().size() > 0 && userTurtles().every { it.speed == 0 && it.state != UserTurtle.State.ACCELERATING } 

		if (isDeadlocked) {
			println("Deadlock occurred!")
			yieldZones().get(0).unlockYieldZone()
//			pause() 
		}
	}
	
	def carsOnTheRoad() {
		count(userTurtles())
	}
	
	def crashRate() {
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
		ask(poissonStreams()) {
			sum += totalTravelTime
			count += numCarsArrived
		}
		if (count == 0) return 0
		sum / count
	}
	
	def meanTravelTimeN() {
		streams[3].meanTravelTime()
	}
	
	def meanTravelTimeS() {
		streams[2].meanTravelTime()
	}
	
	def meanTravelTimeW() {
		streams[0].meanTravelTime()
	}
	
	def meanTravelTimeE() {
		streams[1].meanTravelTime()
	}
}
