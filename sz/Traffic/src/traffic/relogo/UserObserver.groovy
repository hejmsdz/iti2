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

	@Setup
	def setup(){
		clearAll()
		setDefaultShape(UserTurtle, "car")
		
		def w = (UserPatch.laneWidth + 1) / 2
		def d = 15
		for (pos in [[-1, 0], [1, 0], [0, -1], [0, 1]]) {
			def (x, y) = pos
			def sign = (x + y) * w
			createPoissonStreams(1) {
				def xOffset = -sign * (1 - Math.abs(x))
				def yOffset = sign * (1 - Math.abs(y))
				setxy(d * x + xOffset, d * y + yOffset)
				facexy(xOffset, yOffset)
				setColor(sky() + 2)
			}
		}
		
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
		resetTimer()
	}
}