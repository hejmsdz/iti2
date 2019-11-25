package traffic;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoLink<T> extends BaseLink<T>	{

	/**
	 * Returns an agentset of destinations on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of destinations on patch p
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> destinationsOn(Patch p){
		AgentSet<traffic.relogo.Destination> result = new AgentSet<traffic.relogo.Destination>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"destination")){
			if (t instanceof traffic.relogo.Destination)
			result.add((traffic.relogo.Destination)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of destinations on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of destinations on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> destinationsOn(Turtle t){
		AgentSet<traffic.relogo.Destination> result = new AgentSet<traffic.relogo.Destination>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"destination")){
			if (tt instanceof traffic.relogo.Destination)
			result.add((traffic.relogo.Destination)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of destinations on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of destinations on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> destinationsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<traffic.relogo.Destination>();
		}

		Set<traffic.relogo.Destination> total = new HashSet<traffic.relogo.Destination>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(destinationsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(destinationsOn(p));
				}
			}
		}
		return new AgentSet<traffic.relogo.Destination>(total);
	}

	/**
	 * Queries if object is a destination.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a destination
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public boolean isDestinationQ(Object o){
		return (o instanceof traffic.relogo.Destination);
	}

	/**
	 * Returns the destination with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public traffic.relogo.Destination destination(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof traffic.relogo.Destination)
			return (traffic.relogo.Destination) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all destinations.
	 * 
	 * @return agentset of all destinations
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> destinations(){
		AgentSet<traffic.relogo.Destination> a = new AgentSet<traffic.relogo.Destination>();
		for (Object e : this.getMyObserver().getContext().getObjects(traffic.relogo.Destination.class)) {
			if (e instanceof traffic.relogo.Destination){
				a.add((traffic.relogo.Destination)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of poissonStreams on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of poissonStreams on patch p
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> poissonStreamsOn(Patch p){
		AgentSet<traffic.relogo.PoissonStream> result = new AgentSet<traffic.relogo.PoissonStream>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"poissonStream")){
			if (t instanceof traffic.relogo.PoissonStream)
			result.add((traffic.relogo.PoissonStream)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of poissonStreams on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of poissonStreams on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> poissonStreamsOn(Turtle t){
		AgentSet<traffic.relogo.PoissonStream> result = new AgentSet<traffic.relogo.PoissonStream>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"poissonStream")){
			if (tt instanceof traffic.relogo.PoissonStream)
			result.add((traffic.relogo.PoissonStream)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of poissonStreams on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of poissonStreams on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> poissonStreamsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<traffic.relogo.PoissonStream>();
		}

		Set<traffic.relogo.PoissonStream> total = new HashSet<traffic.relogo.PoissonStream>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(poissonStreamsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(poissonStreamsOn(p));
				}
			}
		}
		return new AgentSet<traffic.relogo.PoissonStream>(total);
	}

	/**
	 * Queries if object is a poissonStream.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a poissonStream
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public boolean isPoissonStreamQ(Object o){
		return (o instanceof traffic.relogo.PoissonStream);
	}

	/**
	 * Returns the poissonStream with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public traffic.relogo.PoissonStream poissonStream(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof traffic.relogo.PoissonStream)
			return (traffic.relogo.PoissonStream) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all poissonStreams.
	 * 
	 * @return agentset of all poissonStreams
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> poissonStreams(){
		AgentSet<traffic.relogo.PoissonStream> a = new AgentSet<traffic.relogo.PoissonStream>();
		for (Object e : this.getMyObserver().getContext().getObjects(traffic.relogo.PoissonStream.class)) {
			if (e instanceof traffic.relogo.PoissonStream){
				a.add((traffic.relogo.PoissonStream)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of roundabouts on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of roundabouts on patch p
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Roundabout")
	public AgentSet<traffic.relogo.Roundabout> roundaboutsOn(Patch p){
		AgentSet<traffic.relogo.Roundabout> result = new AgentSet<traffic.relogo.Roundabout>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"roundabout")){
			if (t instanceof traffic.relogo.Roundabout)
			result.add((traffic.relogo.Roundabout)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of roundabouts on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of roundabouts on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Roundabout")
	public AgentSet<traffic.relogo.Roundabout> roundaboutsOn(Turtle t){
		AgentSet<traffic.relogo.Roundabout> result = new AgentSet<traffic.relogo.Roundabout>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"roundabout")){
			if (tt instanceof traffic.relogo.Roundabout)
			result.add((traffic.relogo.Roundabout)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of roundabouts on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of roundabouts on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Roundabout")
	public AgentSet<traffic.relogo.Roundabout> roundaboutsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<traffic.relogo.Roundabout>();
		}

		Set<traffic.relogo.Roundabout> total = new HashSet<traffic.relogo.Roundabout>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(roundaboutsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(roundaboutsOn(p));
				}
			}
		}
		return new AgentSet<traffic.relogo.Roundabout>(total);
	}

	/**
	 * Queries if object is a roundabout.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a roundabout
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Roundabout")
	public boolean isRoundaboutQ(Object o){
		return (o instanceof traffic.relogo.Roundabout);
	}

	/**
	 * Returns the roundabout with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Roundabout")
	public traffic.relogo.Roundabout roundabout(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof traffic.relogo.Roundabout)
			return (traffic.relogo.Roundabout) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all roundabouts.
	 * 
	 * @return agentset of all roundabouts
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Roundabout")
	public AgentSet<traffic.relogo.Roundabout> roundabouts(){
		AgentSet<traffic.relogo.Roundabout> a = new AgentSet<traffic.relogo.Roundabout>();
		for (Object e : this.getMyObserver().getContext().getObjects(traffic.relogo.Roundabout.class)) {
			if (e instanceof traffic.relogo.Roundabout){
				a.add((traffic.relogo.Roundabout)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<traffic.relogo.UserTurtle> result = new AgentSet<traffic.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
			if (t instanceof traffic.relogo.UserTurtle)
			result.add((traffic.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<traffic.relogo.UserTurtle> result = new AgentSet<traffic.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
			if (tt instanceof traffic.relogo.UserTurtle)
			result.add((traffic.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<traffic.relogo.UserTurtle>();
		}

		Set<traffic.relogo.UserTurtle> total = new HashSet<traffic.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<traffic.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof traffic.relogo.UserTurtle);
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public traffic.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof traffic.relogo.UserTurtle)
			return (traffic.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> userTurtles(){
		AgentSet<traffic.relogo.UserTurtle> a = new AgentSet<traffic.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(traffic.relogo.UserTurtle.class)) {
			if (e instanceof traffic.relogo.UserTurtle){
				a.add((traffic.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of yieldZones on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of yieldZones on patch p
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.YieldZone")
	public AgentSet<traffic.relogo.YieldZone> yieldZonesOn(Patch p){
		AgentSet<traffic.relogo.YieldZone> result = new AgentSet<traffic.relogo.YieldZone>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"yieldZone")){
			if (t instanceof traffic.relogo.YieldZone)
			result.add((traffic.relogo.YieldZone)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of yieldZones on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of yieldZones on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.YieldZone")
	public AgentSet<traffic.relogo.YieldZone> yieldZonesOn(Turtle t){
		AgentSet<traffic.relogo.YieldZone> result = new AgentSet<traffic.relogo.YieldZone>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"yieldZone")){
			if (tt instanceof traffic.relogo.YieldZone)
			result.add((traffic.relogo.YieldZone)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of yieldZones on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of yieldZones on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.YieldZone")
	public AgentSet<traffic.relogo.YieldZone> yieldZonesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<traffic.relogo.YieldZone>();
		}

		Set<traffic.relogo.YieldZone> total = new HashSet<traffic.relogo.YieldZone>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(yieldZonesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(yieldZonesOn(p));
				}
			}
		}
		return new AgentSet<traffic.relogo.YieldZone>(total);
	}

	/**
	 * Queries if object is a yieldZone.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a yieldZone
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.YieldZone")
	public boolean isYieldZoneQ(Object o){
		return (o instanceof traffic.relogo.YieldZone);
	}

	/**
	 * Returns the yieldZone with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.YieldZone")
	public traffic.relogo.YieldZone yieldZone(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof traffic.relogo.YieldZone)
			return (traffic.relogo.YieldZone) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all yieldZones.
	 * 
	 * @return agentset of all yieldZones
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.YieldZone")
	public AgentSet<traffic.relogo.YieldZone> yieldZones(){
		AgentSet<traffic.relogo.YieldZone> a = new AgentSet<traffic.relogo.YieldZone>();
		for (Object e : this.getMyObserver().getContext().getObjects(traffic.relogo.YieldZone.class)) {
			if (e instanceof traffic.relogo.YieldZone){
				a.add((traffic.relogo.YieldZone)e);
			}
		}
		return a;
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof traffic.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public AgentSet<traffic.relogo.UserLink> userLinks(){
		AgentSet<traffic.relogo.UserLink> a = new AgentSet<traffic.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(traffic.relogo.UserLink.class)) {
			if (e instanceof traffic.relogo.UserLink){
				a.add((traffic.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public traffic.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (traffic.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserLink")
	public traffic.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Returns the value of the global variable greenHorizontally.
	 *
	 * @return the value of the global variable greenHorizontally
	 */
	@ReLogoBuilderGeneratedFor("global: greenHorizontally")
	public Object getGreenHorizontally(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("greenHorizontally");
	}

	/**
	 * Sets the value of the global variable greenHorizontally.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: greenHorizontally")
	public void setGreenHorizontally(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("greenHorizontally",value);
	}

	/**
	 * Returns the value of the global variable intersectionType.
	 *
	 * @return the value of the global variable intersectionType
	 */
	@ReLogoBuilderGeneratedFor("global: intersectionType")
	public Object getIntersectionType(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("intersectionType");
	}

	/**
	 * Sets the value of the global variable intersectionType.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: intersectionType")
	public void setIntersectionType(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("intersectionType",value);
	}

	/**
	 * Returns the value of the global variable acceleration.
	 *
	 * @return the value of the global variable acceleration
	 */
	@ReLogoBuilderGeneratedFor("global: acceleration")
	public Object getAcceleration(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("acceleration");
	}

	/**
	 * Sets the value of the global variable acceleration.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: acceleration")
	public void setAcceleration(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("acceleration",value);
	}

	/**
	 * Returns the value of the global variable deceleration.
	 *
	 * @return the value of the global variable deceleration
	 */
	@ReLogoBuilderGeneratedFor("global: deceleration")
	public Object getDeceleration(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("deceleration");
	}

	/**
	 * Sets the value of the global variable deceleration.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: deceleration")
	public void setDeceleration(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("deceleration",value);
	}

	/**
	 * Returns the value of the global variable maxSpeed.
	 *
	 * @return the value of the global variable maxSpeed
	 */
	@ReLogoBuilderGeneratedFor("global: maxSpeed")
	public Object getMaxSpeed(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("maxSpeed");
	}

	/**
	 * Sets the value of the global variable maxSpeed.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: maxSpeed")
	public void setMaxSpeed(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("maxSpeed",value);
	}

	/**
	 * Returns the value of the global variable poissonStreamRate.
	 *
	 * @return the value of the global variable poissonStreamRate
	 */
	@ReLogoBuilderGeneratedFor("global: poissonStreamRate")
	public Object getPoissonStreamRate(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("poissonStreamRate");
	}

	/**
	 * Sets the value of the global variable poissonStreamRate.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: poissonStreamRate")
	public void setPoissonStreamRate(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("poissonStreamRate",value);
	}

	/**
	 * Returns the value of the global variable turningThreshold.
	 *
	 * @return the value of the global variable turningThreshold
	 */
	@ReLogoBuilderGeneratedFor("global: turningThreshold")
	public Object getTurningThreshold(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("turningThreshold");
	}

	/**
	 * Sets the value of the global variable turningThreshold.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: turningThreshold")
	public void setTurningThreshold(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("turningThreshold",value);
	}


}