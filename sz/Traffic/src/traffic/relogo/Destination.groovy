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
	
	def step(double dt) {
		ask(userTurtlesHere()) { car ->
			if (car.destination == this) {
				println("Car reached destination!")
				car.die()
			}
		}
	}
	
	def register() {
		instances.add(this)
	}
}
