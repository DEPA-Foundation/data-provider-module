The data provider module is perhaps the most crucial piece of software in the DEPA ecosystem. The reason for this is that in order to be consumers of DEPA data, companies also need to be providers of data. Therefore, nothing can accelerate the adoption of the DEPA framework faster than a data provider module which makes it as easy as possible for companies to plug in and begin sharing their data.

A well designed data provider module (DPM) will help with the following tasks:
- Connecting with a legacy data store (most banks offer access to their Oracle/Finacle/RDBMS systems via some API gateway)
- Authenticating that incoming consent requests are coming from valid Account Aggregators (AAs)
- Verifying the authenticity of digital signatures coming from the AAs
- Logging and storage of electronic consent artefacts
- Allowing for discovery and linking of user accounts
- Efficiently interpreting and executing data filtering as per the consent request
- Formatting outgoing data as per the defined schema
- Correctly encrypting outgoing data
- Maximizing the speed and scalability of all APIs
- Optimizing reliability, redundancy, and uptime
- Managing an audit trail and log system
- Maintaining a heartbeat protocol 

The ideal scenario is that we produce a scaleable and clean piece of software which companies can easily customize and deploy as per their requirements. 

The open API specifications for the DEPA system can be found here - https://api.rebit.org.in/

The standardized document schemas for financial data documents can be found here - https://api.rebit.org.in/schema

A corporate sandbox simulating a DPM (at an abstracted level) can be found here - https://finvu.github.io/sandbox/fip_simulator/ 

Another corporate sandbox detailing some APIs and process flows can be found here - https://www.onemoney.in/docs/api/ui_flows/
