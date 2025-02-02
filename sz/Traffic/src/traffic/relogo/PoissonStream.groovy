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

class PoissonStream extends ReLogoTurtle {
	def timeToHatch = randomExponential(poissonStreamRate)
	def destinations = []
	
	def totalTravelTime = 0
	def numCarsArrived = 0
	
	def step(double dt) {
		if (timeToHatch > 0) {
			timeToHatch -= dt
		} else {
			if (inCone(userTurtles(), 4, 70).size()) {
				return
			}
			def randomDestination = Destination.instances[destinations[random(destinations.size)]]
			hatchUserTurtles(1) {
				source = this
				destination = randomDestination
			}
			timeToHatch = randomExponential(poissonStreamRate)
		}
	}
	
	def meanTravelTime() {
		if (numCarsArrived == 0) return 0
		totalTravelTime / numCarsArrived
	}
}
