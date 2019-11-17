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
	def poissonStreamRate = 0.2
	def timeToHatch = 0
	
	
	def step(double dt) {
		if (timeToHatch > 0) {
			timeToHatch -= dt
		} else {
			hatchUserTurtles(1)
			timeToHatch = randomExponential(poissonStreamRate)
		}
	}
}
