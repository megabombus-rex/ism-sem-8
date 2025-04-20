# Information Systems Modelling laboratory
The project Dreams For Sale is done for an imaginatory company DreamsSellers.

## Instalation
To compile the project you need to clone the Github repository. Using Maven, generate sources from corrected_openapi.yaml.
If there is no database file, you'll have to change the line:
spring.jpa.hibernate.ddl-auto=update
in source/main/resources/application.properties to
spring.jpa.hibernate.ddl-auto=create

Then you run the application in IntelliJ IDEA.

## Available API features

Endpoints implemented:

### POST:
creating a vendor:
/auth/signup/vendor
/admin/vendors

sign in:
/auth/login

registering a business:
/vendors/{vendorId}/registerBusiness

post a new gift:
/services/{businessId}/gift


### GET:
a filtered list of gifts:
/gifts

aspect oriented programming (AOP):
/aspect

## Frontend

This is a [Next.js](https://nextjs.org) project bootstrapped with [`create-next-app`](https://nextjs.org/docs/app/api-reference/cli/create-next-app).

## Getting Started

First, run the development server:

```bash
npm run dev
# or
yarn dev
# or
pnpm dev
# or
bun dev
```

Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

