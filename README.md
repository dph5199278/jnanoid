# JNanoId
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.dph5199278/jnanoid/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.dph5199278/jnanoid)

A unique string ID generator for Java.

### Secure
JNanoID uses Java’s [SecureRandom](https://docs.oracle.com/javase/6/docs/api/java/security/SecureRandom.html) to generate cryptographically strong random IDs with a proper distribution of characters.

### Compact
JNanoID generates compact IDs with just 21 characters. By using a larger alphabet than UUID, JNanoID can generate a greater number of unique IDs, when compared to UUID, with fewer characters (21 versus 36).

### URL-Friendly
JNanoID uses URL-friendly characters (`A-Za-z0-9_-`). Perfect for unique identifiers in web applications.

### Customizable
JNanoID is fully customizable. All default options may be overridden. Supply your own Random Number Generator, alphabet, or size.

### Tested
JNanoID is thoroughly tested with JUnit.

## Latest Release

The most recent release is JNanoId jdk6.

### Maven

```xml
<dependency>
  <groupId>io.github.dph5199278</groupId>
  <artifactId>jnanoid</artifactId>
  <version>jdk6</version>
</dependency>
```

### Gradle

version: before 4.7
```groovy
compile 'io.github.dph5199278:jnanoid:jdk6'
```

version: after 4.7 and 4.7
```groovy
implementation 'io.github.dph5199278:jnanoid:jdk6'
```

## Usage

JNanoId provides one easy-to-use enum class (`NanoId`) with five methods to generate IDs.

#### Standard IDs - `randomNanoId()`

The default method creates secure, url-friendly, unique ids. It uses a url-friendly alphabet (`A-Za-z0-9_-`), a secure random number generator, and generates a unique ID with 21 characters.

```java
String id = NanoId.INSTANCE.randomNanoId(); // "ku-qLNv1wDmIS5_EcT3j7"
```

#### Custom IDs - `NanoId.INSTANCE.randomNanoId(random, alphabet, size);`

An additional method allows you to generate custom IDs by specifying your own random number generator, alphabet, or size.

```java

// Use a faster, but non-secure, random generator
Random random = new Random();

// Use a custom alphabet containing only a, b, and c
    char[] alphabet = {'a','b','c'};

// Make IDs 10 characters long
    int size = 10;

    String id = NanoId.INSTANCE.randomNanoId(random, alphabet, 10); // "babbcaabcb"
```

## Copyright and license

Code copyright 2022 [The JNanoID Authors](https://github.com/dph5199278/jnanoid/graphs/contributors). Code released under the [MIT License](https://github.com/dph5199278/jnanoid/blob/master/LICENSE).

Based on the original [NanoId](https://github.com/ai/nanoid) for JavaScript by [Andrey Sitnik](https://github.com/ai/).

## Other Programming Languages

* [C#](https://github.com/codeyu/nanoid-net)
* [Clojure and ClojureScript](https://github.com/zelark/nano-id)
* [Crystal](https://github.com/mamantoha/nanoid.cr)
* [Dart](https://github.com/pd4d10/nanoid)
* [Go](https://github.com/matoous/go-nanoid)
* [Elixir](https://github.com/railsmechanic/nanoid)
* [Haskell](https://github.com/4e6/nanoid-hs)
* [JavaScript](https://github.com/ai/nanoid)
* [Nim](https://github.com/icyphox/nanoid.nim)
* [PHP](https://github.com/hidehalo/nanoid-php)
* [Python](https://github.com/puyuan/py-nanoid)
* [Ruby](https://github.com/radeno/nanoid.rb)
* [Rust](https://github.com/nikolay-govorov/nanoid)
* [Swift](https://github.com/antiflasher/NanoID)

Also, a [CLI tool] is available to generate IDs from the command line.

[CLI tool]: https://github.com/twhitbeck/nanoid-cli
