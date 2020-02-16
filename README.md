# <p style="text-align: center;" align="center">aimutil</p>

<p style="text-align: center;" align="center">Helper classes for various tasks</p>

___

## Table of content
- [Installation](#installation)
    - [Maven](#maven)
    - [Gradle](#gradle)
- [Examples](#examples)
    - [Compress a folder to zip](#compress-a-folder-to-zip)
    
## Installation

Download the jar file from the [releases](https://github.com/bytesaim/aimutil/releases) and add the downloaded `aimutil-$.jar` to your java or android project class path or library folder.

### Maven 

Add the following repository and dependency detail to your pom.xml

Using mvn-repo:

```xml
<dependencies>
    <dependency>
        <groupId>com.bytesaim</groupId>
        <artifactId>aimutil</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>

<repositories>
    <repository>
        <id>aimutil</id>
        <url>https://raw.github.com/bytesaim/aimutil/mvn-repo/</url>
    </repository>
</repositories>
```

Using jitpack.io:

```xml
<dependencies>
    <dependency>
        <groupId>com.github.bytesaim</groupId>
        <artifactId>aimutil</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

### Gradle

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency:

```gradle
dependencies {
        implementation 'com.github.bytesaim:aimutil:1.0'
}
```

## Examples

### Compress a folder to zip

A basic route on the main endpoint and greet_endpoit over GET method

```java
import com.bytesaim.util.*;

public class TestAimZip {
    public static void main(String[] args) throws UnknownHostException {
        
    }
}
```