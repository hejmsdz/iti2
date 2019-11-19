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
	def state = State.ACCELERATING
	Destination destination = null
	def crashed = false

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
		
		def threshold = 0.8
		
		if ((Math.abs(getXcor() - destination.getXcor()) < threshold) ^ (Math.abs(getYcor() - destination.getYcor()) < threshold)) {
			face(destination)
		}

		if (crashed) {
			die()
			return
		}
		
		forward(speed * dt)
		
		def collisions = userTurtlesHere()
		if (collisions.size() > 1) {
			ask(collisions) {
				crash()
			}
			return
		}
		
		if (patchHere().getPcolor() == green()) {
			die()
		}
	}
	
	def setDestination(Destination value) {
		destination = value 
		setColor(destination.getColor())
	}

	def crash() {
		crashed = true
	}
}
