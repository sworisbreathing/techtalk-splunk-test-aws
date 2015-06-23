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



## Ecetera's Mission

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



# The App

(a.k.a. "what are we upgrading?")<!-- .element: style="font-size: 0.8em;" -->



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



## Splunk Apps and AddOns

Really just configuration bundles<!-- .element: class="fragment" data-fragment-index="1" -->

Can also include UI components (dashboards)<!-- .element: class="fragment" data-fragment-index="2" -->



## Deployment Server

Deploys apps/addons to Splunk instances<!-- .element: class="fragment" data-fragment-index="1" -->

(similar to Puppet/Chef, but Splunk-specific)<!-- .element: class="fragment" data-fragment-index="2" -->



# Upgrade Paths



## Two Major Changes

Upgrade Splunk across all environments<!-- .element: class="fragment" data-fragment-index="1" -->

Improve Splunk app deployment process<!-- .element: class="fragment" data-fragment-index="2" -->



## Why Upgrade Splunk?

Latest release: 6.2.3<!-- .element: class="fragment" data-fragment-index="1" -->

Currently deployed: 5.0.2<!-- .element: class="fragment" data-fragment-index="2" -->

5.x release is more than 24 months old<!-- .element: class="fragment" data-fragment-index="3" -->

Will reach End-Of-Life when 7.x is released<!-- .element: class="fragment" data-fragment-index="3" -->



# Creating A Test Environment



## AWS (Simplified Version)

VMs provisioned "in the cloud"<!-- .element: class="fragment" data-fragment-index="1" -->

Pay only for what you use<!-- .element: class="fragment" data-fragment-index="2" -->

Well-documented APIs for automation<!-- .element: class="fragment" data-fragment-index="3" -->



## ![Terraform Logo](./images/terraform-logo.png) Terraform
<!-- .element: class="terraform-logo" -->

Automates the nuts and bolts<!-- .element: class="fragment" data-fragment-index="1" -->

Create VMs<!-- .element: class="fragment" data-fragment-index="2" -->

Manage DNS and Networking<!-- .element: class="fragment" data-fragment-index="2" -->



## Terraform Config Example

    resource "aws_instance" "my_server_name" {
      instance_type = "t1.micro"
      ami = "${lookup(var.aws_amis, var.aws_region)}"
      key_name = "${var.TF_VAR_key_name}"

      connection {
        user = "ubuntu"
        key_file = "${var.TF_VAR_key_path}"
      }

      security_groups = [ "SSH" ]

      tags = {
        Name = "my_server_name"
      }
    }



# So... How Did It Go?



## The Good



### Quick turnaround for testing of changes

Time to create a new test environment from scratch: Less than
5 minutes<!-- .element: class="fragment" data-fragment-index="1" -->

Environments created and destroyed in a two-week period: approx. 100<!-- .element: class="fragment" data-fragment-index="2" -->



### Problems Identified During Testing

Shell scripts for data collection (Unix TA) lost their execute
permissions<!-- .element: class="fragment" data-fragment-index="1" -->

(refactoring was performed on Windows)<!-- .element: class="fragment" data-fragment-index="1" style="font-size: 0.8em;" -->

Fixed before it went into Production<!-- .element: class="fragment" data-fragment-index="2" -->

(yaaay testing!)<!-- .element: class="fragment" data-fragment-index="2" style="font-size: 0.8em;" -->



## The Bad



### Splunk Upgrades on RHEL/CentOS

Would not overwrite existing files/folders<!-- .element: class="fragment" data-fragment-index="1" -->

Manual intervention required for these hosts<!-- .element: class="fragment" data-fragment-index="1" style="font-size: 0.8em;" -->

Upgrade of Splunk was only tested on Ubuntu<!-- .element: class="fragment" data-fragment-index="2" -->

(I forgot they were using multiple distros)<!-- .element: class="fragment" data-fragment-index="2" style="font-size: 0.8em;" -->



### Alerts Lost

Version Control Repo not up-to-date<!-- .element: class="fragment" data-fragment-index="1" -->

Restored from nightly backup<!-- .element: class="fragment" data-fragment-index="2" -->

(and version control updated)<!-- .element: class="fragment" data-fragment-index="2" style="font-size: 0.8em;" -->

(yaaay backups!)<!-- .element: class="fragment" data-fragment-index="3" style="font-size: 0.8em;" -->



# Conclusions

Cloud is well suited for this use case<!-- .element: class="fragment" data-fragment-index="1" -->

Tooling is easy to learn<!-- .element: class="fragment" data-fragment-index="2" -->

(I can barely spell AWS)<!-- .element: class="fragment" data-fragment-index="2" style="font-size: 0.8em;" -->



## Bottom Line

There's no excuse for having to wait for a test environment anymore<!-- .element: class="fragment" data-fragment-index="1" -->



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
