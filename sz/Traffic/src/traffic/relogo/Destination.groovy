package traffic.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup
import traffic.ReLogoTurtle

class Destination extends ReLogoTurtle {
	static instances = []
	def totalTravelTime = 0
	def numCarsArrived = 0
	
	def step(double dt) {
		ask(userTurtlesHere()) { car ->
			if (car.destination == this) {
				totalTravelTime += (System.currentTimeMillis() - car.createdAt) / 1000
				numCarsArrived++
				car.destroy()
			}
		}
	}
	
	def register() {
		instances.add(this)
	}
	
	def meanTravelTime() {
		if (numCarsArrived == 0) return 0
		totalTravelTime / numCarsArrived
	}
}
