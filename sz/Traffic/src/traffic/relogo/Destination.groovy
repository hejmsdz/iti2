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
	def carsArrivedHere = 0
	
	def step(double dt) {
		ask(userTurtlesHere()) { car ->
			if (car.destination == this) {
				car.source.totalTravelTime += (System.currentTimeMillis() - car.createdAt) / 1000
				car.source.numCarsArrived++
				carsArrivedHere++
				car.destroy()
			}
		}
		
		setLabel(carsArrivedHere)
	}
	
	def register() {
		instances.add(this)
	}
}
