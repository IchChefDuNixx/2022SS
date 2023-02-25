_Exercise assignment for the course [Introduction to AI (partII)](https://inf-git.fh-rosenheim.de/aai-ai2/hsro-aai-ai2-github-io) in the [Bachelor of AAI](https://www.th-rosenheim.de/en/technology/computer-science-mathematics/applied-artificial-intelligence-bachelors-degree) at [Rosenheim University of Applied Sciences](http://www.th-rosenheim.de)_


# 08 - Convolutional Neural Networks

For this exercise you can find some hints within the provided Jupyter Notebooks.

**Solution is provided within the branch "musterloesung".**

## Exercise 1: Convolution

#### a)

Given is the following matrix M:


```
   |  0   50   0  29 |
   |  0   80  31   2 |
M= |  33  90   0  75 |
   |  0    9   0  95 |
```

- Calculate convolution of M with matrix C (step size 1 in both directions): `conv(M,C)`

with 

```
    | −1  0  1 |
C = | −2  0  2 |
    | −1  0  1 |
```

- Calculate `MaxPooling` with pool size (2,2) and stride of 1: `MaxPooling(M, PoolSize = (2, 2))`

- Calculate `AveragePooling` with pool size (2,2) and stride of 1: `AvgPooling(M, PoolSize = (2, 2))`

#### b) Validation

Please validate your results of a) with Python code!

## Exercise 2:  Convolutional Neural Networks with Keras (CNN)

Consider a convolutional neural network that is used to classify images into two classes.

The structure of the network is as follows:
- INPUT: 100x100 grayscale images.
- LAYER 1: Convolutional layer with 100 5x5 convolutional filters.
- LAYER 2: Convolutional layer with 100 5x5 convolutional filters.
- LAYER 3: A max pooling layer with pool size (4,4) and step size 2

- LAYER 4: Dense layer with ??? units
- LAYER 6: Single output unit

**What is the size of layer 4?**

## Exercise 3: CNN in practice

#### a) Loading data

- A, Download the CIFAR10 dataset via the Keras API.
- B, How many training and test images do we have?
- C, What are the dimensions of the images? (N x M pixel)
- D, Plot 2 images from each class!

#### b) Mode fitting

- A: Create a convolutional neural network via Keras
  - network should have the following layers:
  - input of (32, 32, 3)
  - conv2D, 16 kernels, kernel size = 3, valid padding, ReLu actvation
  - conv2D, 16 kernels, kernel size = 3, valid padding, ReLu actvation
  - maxpooling kernel size = 2*2
  - conv2D, 32 kernels, kernel size = 3, valid padding, ReLu actvation
  - conv2D, 32 kernels, kernel size = 3, valid padding, ReLu actvation
  - maxpooling kernel size = 2*2
  - flatten
  - Dense, 10 neurons, softmax activation

- B: Fit the neural network (CNN) for the training data.
  - use Adam optimizer with its default settings
  - use batch size of 64
  - use accuracy as a metric
  - use categorical_crossentropy loss
  - print the metric after each epoch for both the train and the test set!
  - norm the images to have the pixel values between 0-1 (instead of 0-255)
  - convert the labels to one-hot-encoded variables (see to_categorical)
  - train the neural network for 5 epochs
