#Process centric service

The process centric is the main service coordination service. It coordinates other services into a chain of events redirecting and joining the aswers from the services. It interacts with the Business Logic, authentication API using REST like interface.
The business logic service is the main service of System Logic Layer and implements all the internal algorithms and procedures. It interact with authentication-api and data-service and provide a REST-like interface to the Application Layer and to the process-centric-service.

For more information and list of resources/endpoints provided see the [Wiki](../../wiki)

###DEPENDENCIES

	# Authorization keys
	export BUSINESS_AUTH_KEY="business_logic_auth_key"

###HOW TO RUN

	git clone https://github.com/uCoach/process-centric-service.git
	cd process-centric-service
	ant run

#####Deployed on Heorku:

  	https://ucoach-process-centric-service.herokuapp.com
