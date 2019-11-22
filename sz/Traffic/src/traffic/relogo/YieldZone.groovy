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

class YieldZone extends ReLogoTurtle {
	Collection<YieldZone> yieldsTo = []

	def step(double dt) {
		setColor(hasRightOfWay() ? sky() : red())
	}
	
	def hasRightOfWay() {
		yieldsTo.empty || yieldsTo.every { !it.anyCarHere() }
	}
	
	def anyCarHere() {
		inRadius(userTurtles(), UserPatch.laneWidth).size() > 0
	}
}
