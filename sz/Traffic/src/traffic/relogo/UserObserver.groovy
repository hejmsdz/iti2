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
		createTurtles(20){
			def position = random(4)
			switch (position) {
				case 0:
					println("A")
					setxy(-10, 0)
				case 1:
					println("B")
					setxy(0, -10)
				case 2:
					println("C")
					setxy(10, 0)
				case 3:
					println("D")
					setxy(0, 10)
			}
//			facexy(0, 0)
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