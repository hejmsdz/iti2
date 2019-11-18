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
		setDefaultShape(Destination, "house")
		
		def w = (UserPatch.laneWidth + 1) / 2
		def d = 15
		[[-1, 0, red()], [1, 0, green()], [0, -1, blue()], [0, 1, yellow()]].eachWithIndex { pos, index ->
			def (x, y, color) = pos
			def sign = (x + y) * w
			def xOffset = -sign * (1 - Math.abs(x))
			def yOffset = sign * (1 - Math.abs(y))
			createPoissonStreams(1) {
				setxy(d * x + xOffset, d * y + yOffset)
				facexy(xOffset, yOffset)
				destinations = [0,1,2,3] - index
				setColor(white())
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