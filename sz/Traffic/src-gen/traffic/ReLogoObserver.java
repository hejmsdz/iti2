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
public class ReLogoObserver extends BaseObserver{

	/**
	 * Makes a number of randomly oriented destinations and then executes a set of commands on the
	 * created destinations.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created destinations
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> createDestinations(int number, Closure closure) {
		AgentSet<traffic.relogo.Destination> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Destination");
		for (Turtle t : createResult){
			if (t instanceof traffic.relogo.Destination){
				result.add((traffic.relogo.Destination)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented destinations and then executes a set of commands on the
	 * created destinations.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created destinations
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> createDestinations(int number) {
		return createDestinations(number,null);
	}

	/**
	 * Makes a number of uniformly fanned destinations and then executes a set of commands on the
	 * created destinations.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created destinations
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> createOrderedDestinations(int number, Closure closure) {
		AgentSet<traffic.relogo.Destination> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Destination");
		for (Turtle t : createResult){
			if (t instanceof traffic.relogo.Destination){
				result.add((traffic.relogo.Destination)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned destinations and then executes a set of commands on the
	 * created destinations.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created destinations
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> createOrderedDestinations(int number) {
		return createOrderedDestinations(number,null);
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
	 * Returns an agentset containing all destinations.
	 * 
	 * @return agentset of all destinations
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.Destination")
	public AgentSet<traffic.relogo.Destination> destinations(){
		AgentSet<traffic.relogo.Destination> a = new AgentSet<traffic.relogo.Destination>();
		for (Object e : this.getContext().getObjects(traffic.relogo.Destination.class)) {
			if (e instanceof traffic.relogo.Destination){
				a.add((traffic.relogo.Destination)e);
			}
		}
		return a;
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof traffic.relogo.Destination)
			return (traffic.relogo.Destination) turtle;
		return null;
	}

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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"destination")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"destination")){
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
	 * Makes a number of randomly oriented poissonStreams and then executes a set of commands on the
	 * created poissonStreams.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created poissonStreams
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> createPoissonStreams(int number, Closure closure) {
		AgentSet<traffic.relogo.PoissonStream> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"PoissonStream");
		for (Turtle t : createResult){
			if (t instanceof traffic.relogo.PoissonStream){
				result.add((traffic.relogo.PoissonStream)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented poissonStreams and then executes a set of commands on the
	 * created poissonStreams.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created poissonStreams
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> createPoissonStreams(int number) {
		return createPoissonStreams(number,null);
	}

	/**
	 * Makes a number of uniformly fanned poissonStreams and then executes a set of commands on the
	 * created poissonStreams.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created poissonStreams
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> createOrderedPoissonStreams(int number, Closure closure) {
		AgentSet<traffic.relogo.PoissonStream> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"PoissonStream");
		for (Turtle t : createResult){
			if (t instanceof traffic.relogo.PoissonStream){
				result.add((traffic.relogo.PoissonStream)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned poissonStreams and then executes a set of commands on the
	 * created poissonStreams.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created poissonStreams
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> createOrderedPoissonStreams(int number) {
		return createOrderedPoissonStreams(number,null);
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
	 * Returns an agentset containing all poissonStreams.
	 * 
	 * @return agentset of all poissonStreams
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.PoissonStream")
	public AgentSet<traffic.relogo.PoissonStream> poissonStreams(){
		AgentSet<traffic.relogo.PoissonStream> a = new AgentSet<traffic.relogo.PoissonStream>();
		for (Object e : this.getContext().getObjects(traffic.relogo.PoissonStream.class)) {
			if (e instanceof traffic.relogo.PoissonStream){
				a.add((traffic.relogo.PoissonStream)e);
			}
		}
		return a;
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof traffic.relogo.PoissonStream)
			return (traffic.relogo.PoissonStream) turtle;
		return null;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"poissonStream")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"poissonStream")){
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
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> createUserTurtles(int number, Closure closure) {
		AgentSet<traffic.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof traffic.relogo.UserTurtle){
				result.add((traffic.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> createUserTurtles(int number) {
		return createUserTurtles(number,null);
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> createOrderedUserTurtles(int number, Closure closure) {
		AgentSet<traffic.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof traffic.relogo.UserTurtle){
				result.add((traffic.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> createOrderedUserTurtles(int number) {
		return createOrderedUserTurtles(number,null);
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
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("traffic.relogo.UserTurtle")
	public AgentSet<traffic.relogo.UserTurtle> userTurtles(){
		AgentSet<traffic.relogo.UserTurtle> a = new AgentSet<traffic.relogo.UserTurtle>();
		for (Object e : this.getContext().getObjects(traffic.relogo.UserTurtle.class)) {
			if (e instanceof traffic.relogo.UserTurtle){
				a.add((traffic.relogo.UserTurtle)e);
			}
		}
		return a;
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof traffic.relogo.UserTurtle)
			return (traffic.relogo.UserTurtle) turtle;
		return null;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"userTurtle")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"userTurtle")){
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
		for (Object e : this.getContext().getObjects(traffic.relogo.UserLink.class)) {
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
		return (traffic.relogo.UserLink)(this.getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
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
	 * Returns the value of the global variable areTrafficLightsGreenHorizontally.
	 *
	 * @return the value of the global variable areTrafficLightsGreenHorizontally
	 */
	@ReLogoBuilderGeneratedFor("global: areTrafficLightsGreenHorizontally")
	public Object getAreTrafficLightsGreenHorizontally(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("areTrafficLightsGreenHorizontally");
	}

	/**
	 * Sets the value of the global variable areTrafficLightsGreenHorizontally.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: areTrafficLightsGreenHorizontally")
	public void setAreTrafficLightsGreenHorizontally(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("areTrafficLightsGreenHorizontally",value);
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