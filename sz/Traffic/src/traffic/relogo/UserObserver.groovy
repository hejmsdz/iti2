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
		
		createPoissonStreams(1) {
			setxy(-10, 0)
			facexy(0, 0)
		}
		
		createPoissonStreams(1) {
			setxy(10, 0)
			facexy(0, 0)
		}
		
		createPoissonStreams(1) {
			setxy(0, -10)
			facexy(0, 0)
		}
		
		createPoissonStreams(1) {
			setxy(0, 10)
			facexy(0, 0)
		}

		resetTimer()
	}
	
	@Go
	def go(){
		def dt = timer()
		ask(turtles()){
			step(dt)
		}
		ask(poissonStreams()){
			step(dt)
		}
		resetTimer()
	}
}