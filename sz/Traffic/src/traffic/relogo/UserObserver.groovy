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
		areTrafficLightsGreenHorizontally = true
		
		def width = (laneWidth + 1) / 2
		def d = 15

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
			
			createDestinations(1) {
				setxy(d * x - xOffset, d * y - yOffset)
				facexy(xOffset, yOffset)
				setColor(color)
				register()
			}
		}
		
		ask(patches()) {
			setColor()
			changeLights(true)
		}

		resetTimer()
	}
	
	@Go
	def go(){
		def dt = timer()
		ask(turtles()){
			step(dt)
		}
		
		if (Calendar.getInstance().get(Calendar.SECOND) % 20 == 0) {
			ask(patches()) {
				changeLights(true)
			}
		} else if (Calendar.getInstance().get(Calendar.SECOND) % 10 == 0) {
			ask(patches()) {
				changeLights(false)
			}
		}
		
		resetTimer()
	}
}
