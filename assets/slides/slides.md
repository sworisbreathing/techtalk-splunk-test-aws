# The Challenge
We want to upgrade Splunk<!-- .element: class="fragment" data-fragment-index="1" -->



# The Problem
We don't have a test environment<!-- .element: class="fragment" data-fragment-index="1" -->



# The Solution

Let's Build a Test Environment!<!-- .element: class="fragment" data-fragment-index="1" -->

... in AWS<!-- .element: class="fragment" data-fragment-index="2" -->

... with Terraform<!-- .element: class="fragment" data-fragment-index="3" -->

... and Ansible<!-- .element: class="fragment" data-fragment-index="4" -->



# But First...
... A Brief Introduction<!-- .element: class="fragment" data-fragment-index="1" -->



## $whoami

Steven Swor<!-- .element: class="fragment" data-fragment-index="1" -->

sworisbreathing (GitHub, StackExchange)<!-- .element: class="fragment" data-fragment-index="2" -->

steven_swor (Splunk Answers)<!-- .element: class="fragment" data-fragment-index="2" -->

![My gravatar](./images/gravatar.jpeg)<!-- .element: class="fragment" data-fragment-index="2" -->



![Ecetera Logo](./images/ecetera_logo_grey.png)

(ee-SET-uh-ruh)<!-- .element: class="fragment" data-fragment-index="1" -->

http://ecetera.com.au<!-- .element: class="fragment" data-fragment-index="2" -->



## Mission

to rid the world of badly behaving applications<!-- .element: class="fragment" data-fragment-index="1" -->



## What Ecetera Does

DevOps<!-- .element: class="fragment" data-fragment-index="1" -->

Application Performance Monitoring (APM)<!-- .element: class="fragment" data-fragment-index="2" -->

Web-Scale IT<!-- .element: class="fragment" data-fragment-index="3" -->



## What I Do

APM<!-- .element: class="fragment" data-fragment-index="1" -->

Functional Test Automation<!-- .element: class="fragment" data-fragment-index="2" -->

Performance Testing<!-- .element: class="fragment" data-fragment-index="3" -->

Consulting<!-- .element: class="fragment" data-fragment-index="4" -->

Write Jittery Presentations<!-- .element: class="fragment" data-fragment-index="5" -->




## What Don't I Do?

Manage Infrastructure<!-- .element: class="fragment" data-fragment-index="1" -->

(...except when I have to) <!-- .element: class="fragment" data-fragment-index="2" -->



# The Upgrade



![Splunk Logo](./images/splunk-logo.png)

(spluhnk)<!-- .element: class="fragment" data-fragment-index="1" -->

http://splunk.com<!-- .element: class="fragment" data-fragment-index="2" -->



## What Splunk Does

Big Data<!-- .element: class="fragment" data-fragment-index="1" -->

Monitoring/Alerting<!-- .element: class="fragment" data-fragment-index="2" -->

Analytics<!-- .element: class="fragment" data-fragment-index="3" -->



# How Splunk Works

## Simplified Version



## Forwarders

Collect data (logs) from remote systems<!-- .element: class="fragment" data-fragment-index="1" -->

Send collected data to indexers<!-- .element: class="fragment" data-fragment-index="2" -->



## Indexers

Store collected data in indexes<!-- .element: class="fragment" data-fragment-index="1" -->

Fetch data from indexes<br />
(e.g. run search jobs)<!-- .element: class="fragment" data-fragment-index="2" -->



## Search Heads

User Interface (Web)<!-- .element: class="fragment" data-fragment-index="1" -->

Create/Dispatch Search Jobs<!-- .element: class="fragment" data-fragment-index="2" -->



# Acknowledgements



## Reveal.JS

Makes writing presentations easy<!-- .element: class="fragment" data-fragment-index="1" -->

http://lab.hakim.se/reveal-js/<!-- .element: class="fragment" data-fragment-index="2" -->

https://github.com/hakimel/reveal.js<!-- .element: class="fragment" data-fragment-index="2" -->



## D3

Makes transforming HTML easy<!-- .element: class="fragment" data-fragment-index="1" -->

http://d3js.org<!-- .element: class="fragment" data-fragment-index="2" -->

https://github.com/mbostock/d3<!-- .element: class="fragment" data-fragment-index="2" -->



## Jitter Animation

Used with permission from Asymmetric Publications<!-- .element: class="fragment" data-fragment-index="1" -->

http://asymmetric.net/<!-- .element: class="fragment" data-fragment-index="2" -->

http://www.kingdomofloathing.com<!-- .element: class="fragment" data-fragment-index="2" -->

![A Splunk Ninja Is You!](./images/leftswordguy.gif)<!-- .element: class="fragment" data-fragment-index="2" -->
