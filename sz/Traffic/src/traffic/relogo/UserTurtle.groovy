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
	def isPrioritySet = false
	def shouldDestroy = false
	
	def static numAllCars = 0
	def static numCrashes = 0
	
	
	public UserTurtle() {
		super()
		numAllCars++
		createdAt = System.currentTimeMillis()
	}

	def step(double dt) {
		setLabel()
		
		// Stop for cars ahead
		def carsAhead = inCone(userTurtles(), 4, 70).size()
		if (carsAhead >= 1) {
			state = State.BRAKING
			setLabel(carsAhead + " car!")
		} else {
			state = State.ACCELERATING
		}

		// Stop for red light
		def isRedLightAhead = (0..5).each {
			if (patchAhead(it).pcolor == red()) {
				state = State.BRAKING
				setLabel("Green?")
			} 
		}
		
		// Accelerate or decelerate
		if (speed < maxSpeed && state == State.ACCELERATING) {
			speed += acceleration * dt
		} else if (speed >= 0 && state == State.BRAKING) {
			speed -= deceleration * dt
		}

		// Handle max speed
		speed = Math.max(Math.min(speed, maxSpeed), 0)
		
		if (state == State.ACCELERATING && speed >= maxSpeed) {
			state = State.DRIVING
		}

		// Turning
		if ((Math.abs(getXcor() - destination.getXcor()) < turningThreshold) ^
				(Math.abs(getYcor() - destination.getYcor()) < turningThreshold)) {
			face(destination)
		}

		// Collision detection
		if (shouldDestroy) {
			die()
			return
		}
		
		forward(speed * dt)
		
		def collisions = userTurtlesHere()
		if (collisions.size() > 1) {
			ask(collisions) {
				if (shouldDestroy) return
				numCrashes += 1
				destroy()
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

	def destroy() {
		shouldDestroy = true
	}
}
