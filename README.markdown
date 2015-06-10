## Ecetera Techtalk Template.

Ecetera TechTalks are created using Reveal JS.
Everything is contained within this project for you to publish techtalks to the Ecetera techtalks website using SBT.

Purpose is to allow us to quickly create and publish presentations without going to too much trouble setting things up.

---

## How to use this template
Recursive [techtalk-template](http://techtalks.ecetera.com.au/techsync/2015/05/techtalk-template/index.html) template ;) (see techtalk branch)


---

## Clone the template
1. Create a new project at [Gitlab](https://gitlab.services.ecetera.com.au/groups/techtalks)
[](link)

2. Clone template  to your local machine:

```
$ git clone --depth 1 --origin source git@gitlab.services.ecetera.com.au:techtalks/techtalk-template.git newTechTalk
```

3. Add your project's git repository

```
$ cd newTechTalk
$ git remote add origin git@gitlab:techtalks/newTechTalk.git
```

---

## Setup/Configure
1. Edit build.sbt to provide the URI of the talk. You __MUST__ provide a name or the build will fail in order to prevent
spurious uploads to S3.

```
// Give your techtalk a unique-ish name!
// Can be:
// name := "foobar"
name := "foobar"
```

by default a ```<YEAR>/<MONTH>/``` will be prefixed to the name, such that the talk would be at
    http://techtalks.ecetera.com.au/techsync/2015/05/foobar/index.html

The prefix can be modified, see the notes in build.sbt for details.

2. (Optional) Set up your AWS credentials.

```
$ cat ~/.s3TechtalksCreds
realm=Amazon S3
host=techtalks.ecetera.com.au
user=<Access Key ID>
password=<Secret Access Key>
```

or add the following environment variables to you shell before executing this build

```
export AWS_ACCESS_KEY=<Access Key ID>
export AWS_SECRET_KEY=<Secret Access Key>
```

---

## Editing your presentation
1. Make sure you change your index.html
```html
...
in <head>
...
    <title>Tech talk presentation template</title>
    <meta name="description" content="A tech talk presentation template ">
    <meta name="author" content="Eceterian">
...
in <body>
...
    <section class="intro">
      <h1>The Ecetera presentation template</h1>
      <p>
      <small>Slides by
        <a href="https://github.com/mistaka0s">Chao Luan</a>
      </small>
      </p>
    </section>
```

---

## Previewing changes
If you're working on a Unix machine, chances are you have python installed. Your presentation must be hosted over HTTP in order to make use of markdown files.

```
$ python -m SimpleHTTPServer 8000
Serving HTTP on 0.0.0.0 port 8000 ..
```

http://localhost:8000/assets/index.html

---

## Publish to S3

```shell
$ sbt s3wsUpload
```

---

## Visit your published techtalk.
Once uploaded, you can access your tech talk at
http://techtalks.ecetera.com.au/techsync/{name}

Eg:
http://techtalks.ecetera.com.au/techsync/2015/05/techtalk-template/index.htm

---

# TODO:
* Fix up themeing and styling
* Finish documentation.
* Intergrate into CI (no need for self publishing)
* Source AWS Keys and Secret from environment