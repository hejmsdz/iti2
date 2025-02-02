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
	enum State { ACCELERATING, BRAKING }
	
	public long createdAt
	def speed = 0.0
	def state = State.ACCELERATING
	Destination destination = null
	PoissonStream source = null
	def shouldDestroy = false
	def hasEnteredRoundabout = false
	def timeOutsideRoundabout = 0
	def carDetectionAngle = 120
	def carDetectionDistance = 4
	
	def static numAllCars = 0
	def static numCrashes = 0
	
	
	public UserTurtle() {
		super()
		numAllCars++
		createdAt = System.currentTimeMillis()
	}
	
	def brake() {
		state = State.BRAKING
	}
	
	def accelerate() {
		state = State.ACCELERATING
	}
	
	
	def step(double dt) {
		giveWay()
		turn()
		move(dt)
		detectCollisions()
		dieIfDestroyed()
	}
	
	def turn() {
		if (inCone(roundabouts(), 3, 70).size() >= 1) { // Enter roundabout, start turning right
			def oldHeading = precision(getHeading(), 0).toInteger()
			def newHeading = (oldHeading + 10).toInteger() % 360

			setHeading(newHeading)
			timeOutsideRoundabout = 0
			hasEnteredRoundabout = true
		} else if (hasEnteredRoundabout && timeOutsideRoundabout > 150) { // Leave roundabout, turn to destination
			setHeading(towards(destination) - 10) // Prevents hard left turns
		} else if (hasEnteredRoundabout) { // Delay before leaving roundabout, prevents turning too early
			timeOutsideRoundabout++
		} else {
			turnToDestination()
		}
	}
	
	def hasCarsAhead() {
		def cars = userTurtles()
		cars.remove(this)
		return inCone(cars, carDetectionDistance, carDetectionAngle).size() >= 1
	}
	
	def isRedLightAhead() {
		(0..2).any {
			def color = patchAhead(it).pcolor
			color == red() || color == orange()
		}
	}
	
	def giveWay() {
		if (shouldYield() || hasCarsAhead() || isRedLightAhead()) {
			brake()
		} else if (state == State.BRAKING) {
			accelerate()
		}
	}
	
	def move(double dt) {
		def preSpeed = speed
		if (state == State.ACCELERATING) {
			speed += acceleration * dt
		} else if (speed >= 0 && state == State.BRAKING) {
			speed -= deceleration * dt
		}

		// Handle max speed
		speed = Math.max(Math.min(speed, maxSpeed), 0)
		forward(speed * dt)
	}
	
	def turnToDestination() {		
		if ((Math.abs(getXcor() - destination.getXcor()) < turningThreshold) ^ (Math.abs(getYcor() - destination.getYcor()) < turningThreshold)) {
			face(destination)
		}
	}
	
	def detectCollisions() {
		def collisions = userTurtlesHere()
		if (collisions.size() > 1) {
			ask(collisions) {
				if (shouldDestroy) return
				numCrashes += 1
				destroy()
			}
			return
		}
	}
	
	def dieIfDestroyed() {
		if (shouldDestroy) {
			die()
			return
		}
		
		if (patchHere().getPcolor() == green()) {
			die()
		}
	}
	
	def shouldYield() {
		return yieldZonesHere().any { !it.hasRightOfWay() }
	}
	
	def setDestination(Destination value) {
		destination = value 
		setColor(destination.getColor())
	}
	
	public def enableMadnessPriority() {
		carDetectionAngle = 30
		carDetectionDistance = 1
	}

	def destroy() {
		shouldDestroy = true
	}
}
