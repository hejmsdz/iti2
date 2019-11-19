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
	
	long createdAt
	def speed = 0
	def state = State.ACCELERATING
	Destination destination = null
	def shouldDestroy = false
	
	def static numAllCars = 0
	def static numCrashes = 0
	
	
	public UserTurtle() {
		super()
		numAllCars++
		createdAt = System.currentTimeMillis()
	}

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

		if (shouldDestroy) {
			die()
			return
		}
		
		forward(speed * dt)
		
		def collisions = userTurtlesHere()
		if (collisions.size() > 1) {
			ask(collisions) {
				destroy()
			}
			numCrashes++
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

	def destroy() {
		shouldDestroy = true
	}
}
