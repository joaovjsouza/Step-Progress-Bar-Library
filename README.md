# Step Progress Bar

**A progress bar with steps that helps the user to know which step they are on**

#### How to add to your project?

**Step 1:** Add the JitPack repository to your build file

```xml
    allprojects {
        repositories {
            maven { url 'https://jitpack.io' }
        }
    }
```

**Step 2:** Add the dependency

```xml
    dependencies {
            implementation 'com.github.joaovjsouza:step-progress-bar-library:version'
    }
```

##### Code example

**Step 1:** Create a layout file and add the step-progress-bar component

```xml
<com.goodluck.step_progress_bar.StepProgressBar
        android:id="@+id/step_progress_bar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

**Step 2:** You can set a background if you want to change de colors

```xml
app:progress_background="@drawable/default_bg" 
```

***Note:*** This is not step is not mandatory and by default it comes with a background configured

```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:id="@+id/background">
        <shape android:shape="rectangle">
            <solid android:color="@color/grey" />
        </shape>
    </item>

    <item android:id="@+id/progress">
        <scale android:scaleWidth="100%">
            <shape android:shape="rectangle">
                <corners
                    android:bottomRightRadius="2dp"
                    android:topRightRadius="2dp" />
                <solid android:color="@color/orange" />
            </shape>
        </scale>
    </item>

</layer-list>
```

**Step 3:** You need to create a step list like this:

***Note:*** I'll be using viewBinding feature but you can use findViewById

```kotlin
val progressbar = binding.stepProgressBar
progressbar.state.steps = mutableListOf("My", "Steps", "Here")
```

> The first index is 1, so to display the step "My" you need to use a code like this:

```kotlin
progressbar.state.actualProgress = 1
```

> If you miss up and set the progress wrong in this case index 4 or 5, the code will set the index to 3, and the code not to break

```kotlin
progressbar.state.actualProgress = 4
//code will set to the last index, 3 in this case
```

> You can use increment() function to increase the progress, and decrement() to decrease

```kotlin
progressBar.state.increment()
//increase +1 progress


progressBar.state.decrement()
//decrease -1 progress
```

#### How to setup custom margins

> The integer is automatically converted to DP

```kotlin
//This code will set margin to the bar, it not includes the texts
progressbar.progressBarMargin.apply {
            top = 10
            right = 10
            left = 10
            bottom = 10
        }
```

> You can set custom margin to the texts too, for example:

```kotlin
//stepLabel is where the step name will be shown
progressbar.tvStepLabelMargin.apply { 
            right = 10
        }
```

> The same is valid to the index

```kotlin
progressbar.tvStepIndexMargin.apply {
            right = 10
        }
```

***Note:*** By default tvStepLabel and tvStepIndex comes with 30dp configured
