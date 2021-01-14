# Stoneboard: Columnless Kanban

This is in essence a GitHub milestone visualizer that adds very lightweight support for defining relationships between
milestones such that a number of milestones form a directed graph (DAG).

The underlying philosophy for this way of looking at engineering work is grounded in the stance that regardless what we
want or need to get done by any given date is quite commonly blocked by mundane and less interesting work. Nonetheless
that work still has to happen for us to unblock the actual value delivery. Therefore it is valuable to make this
explicit and very clearly show the blocking and enabling relationships between themes or objectives
(or whatever you choose to represent using milestones).


## How

For a configured set of organisations the tool iterates through all repositories the current user has access to and
fetches milestones and issues. These are then displayed in a graph visualising the milestone relationships. Specify
milestones dependencies by adding this to a milestone description. For example:

`[foo/bar/3, foo/bar/2]`

The above example defines two blocking or prerequisite dependencies for the given milestone; milestone 2 and 3 in the
repo `foo` in the organisation `bar`.


### Example

![example](stoneboard-example.png)


### Demo

There are two demo instances available, one on [Heroku](https://stoneboard.herokuapp.com/) and one on
[Google Cloud Run](https://stoneboard-jh667k4lfa-lz.a.run.app/). Both are configured to render the milestones and issues
from this repository.


## F#!k it, :squirrel: it

<a href="https://heroku.com/deploy"><img src="https://www.herokucdn.com/deploy/button.svg" alt="Deploy to Heroku"></a>
<br/>
<a href="https://deploy.cloud.run"><img src="https://deploy.cloud.run/button.svg" width="20%" height="auto" alt="Deploy to Google Cloud Run"></a>

Docker images are built from `master` and pushed to
[Github Packages](https://github.com/plan3/stoneboard/packages/189650) and
[Docker Hub](https://hub.docker.com/r/martengustafson/stoneboard).


# FAQ

* Why can't I edit issues and milestones directly in the tool?
   * Because this is a tool aimed at engineering teams that live and breathe Github, make your edits there

* Why isn't due dates on a milestones represented in any way on the board
   * Whatever due date is set on a milestone does not change the fact that work on that milestone _should_ happen after
   any and all blocking milestones has been completed

* Why doesn't milestone titles word wrap?
   * Because your milestone titles should be short, sweet and concise

* What is the philosophy of this tool?
   * The underlying reasoning behind this style of task visualisation and planning is partly covered in the presentation
   _"[Bastardised Kanban](https://speakerdeck.com/chids/bastardised-kanban)"_ from 2015.


# Local development

## Prerequisites

You will need Java 8 and Maven 3 installed and "properly" setup in your path etc.


## Setup

Create a file called `.env` with the following environment variables:

```
GITHUB_CLIENT_ID=A-GITHUB-CLIENT-ID
GITHUB_CLIENT_SECRET=A-GITHUB-CLIENT-SECRET
GITHUB_HOSTNAME=github.com (optional, used for GitHub Enterprise custom domains)
REPOSITORIES=org/repo,org/repo,...
```

You can set up a GitHub app for local dev on [https://github.com/settings/applications](https://github.com/settings/applications),
the callback will be `http://127.0.0.1:5000/login/oauth2/code/github`.


## Start

Assuming that you have the Heroku CLI installed, build and start the app with:
`$ mvn clean package && heroku local:start`
