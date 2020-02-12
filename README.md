## Overview

The data provider module (DPM) is perhaps the most crucial piece of software in the DEPA ecosystem. The reason for this is that in order to be consumers of DEPA data, companies also need to be providers of data. Therefore, nothing can accelerate the adoption of the DEPA framework faster than a data provider module which makes it as easy as possible for companies to plug in and begin sharing their data.

A well designed DPM will help with the following tasks:
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


## Who is the user?

This piece of software is intended to be used by banks or other financial institutions which wish to begin sharing their data via the DEPA framework. Although the initial adopters will be from the financial system, non-financial companies like hospitals and others will also need something like this in the future. So we should ideally design it with that thought in mind.


## How will the data provider module be used?

The DPM will likely be spun up as a web service hosted by the bank/user. It should connect to a user's data store on one end, and talk to account aggregators on the other end. The DPM receives requests from account aggregators (the DPM endpoints are published in a registry hosted by Sahamati). The DPM then authenticates the account aggregator by checking the Sahamati registry to see if the request did indeed come from a certified source. After authenticating the AA and verifying and storing the consent artefact sent by the AA, the DPM should prepare the requested financial data, encrypt it, and send it back to the AA (see the cryptography overview below for more details on the encryption process). 

So in summary, the DPM only talks to the data store of the financial information provider, the Sahamati registry, and account aggregators.


## What does a DPM look like structurally?

The DPM should resemble an API gateway

[The open API specifications for the DEPA system can be found here](https://api.rebit.org.in/)

[The standardized document schemas for financial data documents can be found here](https://api.rebit.org.in/schema)

[A corporate sandbox simulating a DPM (at an abstracted level) can be found here](https://finvu.github.io/sandbox/fip_simulator/)

[Another corporate sandbox detailing some APIs and process flows can be found here](https://www.onemoney.in/docs/api/ui_flows/)

[An overview of the cryptography workflows for DEPA can be found here](https://pdfhost.io/v/PIAeIEG0_NBFCAA__Security_Overview_1_1_1pdf.pdf)

## Documentation
The documentation of the project is available at http://{{host}}/gateway/api-docs

`api-docs` will return a OpenAPI 3.0 compliant JSON scheme. 
If required, you can import this JSON in Postman to visualise the API contracts 

## Dependencies
- Lombok