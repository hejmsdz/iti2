package traffic.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import traffic.ReLogoTurtle;

class UserTurtle extends ReLogoTurtle{
	enum State { ACCELERATING, BRAKING, DRIVING }
	
	def speed = 0
	def maxSpeed = 10
	def acceleration = 10
	def state = State.ACCELERATING
	
	def step(double dt) {
		if (speed < maxSpeed && state == State.ACCELERATING) {
			speed += acceleration * dt
		} else if (speed >= 0 && state == State.BRAKING) {
			speed -= acceleration * dt
		}
		speed = Math.max(Math.min(speed, maxSpeed), 0)
		
		if (state == State.ACCELERATING && speed >= maxSpeed) {
			state = State.DRIVING
		}
		
		forward(speed * dt)
		
		def collisions = userTurtlesHere()
		if (collisions.size() > 1) {
			ask(collisions) {
				die()
			}
			return
		}
		
		if (patchHere().getPcolor() == green()) {
			die()
		}
	}
}