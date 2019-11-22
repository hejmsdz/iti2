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
	
	public long createdAt
	def speed = 0.0
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
	
	def brake() {
		state = State.BRAKING
	}
	
	def accelerate() {
		state = State.ACCELERATING
	}
	
	def drive() {
		state = State.DRIVING
	}

	def step(double dt) {
		giveWay()
		
		move(dt)
		
		turnToDestination()
		detectCollisions()
		dieIfDestroyed()
	}
	
	def hasCarsAhead() {
		def cars = userTurtles()
		cars.remove(this)
		return inCone(cars, 4, 70).size() >= 1
	}
	
	def giveWay() {
		if (shouldYield() || hasCarsAhead()) {
			setLabel("yield!")
			brake()
		} else if (state == State.BRAKING) {
			accelerate()
			setLabel("")
		}
	}
	
	def move(double dt) {
		def preSpeed = speed
		if (state == State.ACCELERATING) {
			speed += acceleration * dt
		} else if (speed >= 0 && state == State.BRAKING) {
			speed -= deceleration * dt
		}
		speed = Math.max(Math.min(speed, maxSpeed), 0)
		forward(speed * dt)
	}
	
	def turnToDestination() {
		def threshold = 0.8
		
		if ((Math.abs(getXcor() - destination.getXcor()) < threshold) ^ (Math.abs(getYcor() - destination.getYcor()) < threshold)) {
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
		def yield = false
		ask(yieldZonesHere()) {
			if (!hasRightOfWay()) {
				yield = true
			}
		}
		yield
	}
	
	def setDestination(Destination value) {
		destination = value 
		setColor(destination.getColor())
	}

	def destroy() {
		shouldDestroy = true
	}
}
