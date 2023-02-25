_Exercise assignment for the course [Introduction to AI (partII)](https://inf-git.fh-rosenheim.de/aai-ai2/hsro-aai-ai2-github-io) in the [Bachelor of AAI](https://www.th-rosenheim.de/en/technology/computer-science-mathematics/applied-artificial-intelligence-bachelors-degree) at [Rosenheim University of Applied Sciences](http://www.th-rosenheim.de)_


# 04 - Perceptron

For this exercise you can find some hints within the provided Jupyter Notebooks.

**Solution is provided within the branch "musterloesung".**

## Exercise 1: Perceptron - Learning Rule hand made

Given the sets M+=[[-3, 1.5],[2,0.25],[1,1]] and M-=[[-2.0, -0.5],[-4,0.1],[0.5,-0.5]]


- Show graphically that these are linearly separable.


- Apply the Perceptron learning rule to these quantities and give a possible sequence of values for the weight vector. Start with the weight vector w=(1,1).


- Bonus: Program the perceptron learning rule in a Jupyter notebook in Python and apply your program to the sets M+ and M-. Does the solution differ from their calculation?


## Exercise 2 - Perceptron with Gradient Descent

Gradient Descent is the process of minimizing a function by following the gradients of the cost function.

This involves knowing the form of the cost as well as the derivative so that from a given point you know the gradient and can move in that direction, e.g. downhill towards the minimum value.

In machine learning, we can use a technique that evaluates and updates the weights every iteration called stochastic gradient descent to minimize the error of a model on our training data.

The way this optimization algorithm works is that each training instance is shown to the model one at a time. The model makes a prediction for a training instance, the error is calculated and the model is updated in order to reduce the error for the next prediction.

This procedure can be used to find the set of weights in a model that result in the smallest error for the model on the training data.

For the Perceptron algorithm, each iteration the weights (w) are updated using the equation:

>w = w + learning_rate * (expected - predicted) * x

Where w is weight being optimized, learning_rate is a learning rate that you must configure (e.g. 0.01), (expected – predicted) is the prediction error for the model on the training data attributed to the weight and x is the input value.

Given is the following code (from lecture!):

```python
def predict(row, weights):
	activation = weights[0]
	for i in range(len(row)-1):
		activation += weights[i + 1] * row[i]
	return 1.0 if activation >= 0.0 else 0.0
 
# test predictions
dataset = [[2.7810836,2.550537003,0],
	[1.465489372,2.362125076,0],
	[3.396561688,4.400293529,0],
	[1.38807019,1.850220317,0],
	[3.06407232,3.005305973,0],
	[7.627531214,2.759262235,1],
	[5.332441248,2.088626775,1],
	[6.922596716,1.77106367,1],
	[8.675418651,-0.242068655,1],
	[7.673756466,3.508563011,1]]

# in this example this is given weights= [bias, w1, w2]
weights = [-0.1, 0.20653640140000007, -0.23418117710000003]

for row in dataset:
	prediction = predict(row, weights)
	print("Expected=%d, Predicted=%d" % (row[-1], prediction))
```

**Can you train the weights?**

We can estimate the weight values for our training data using stochastic gradient descent.

Stochastic gradient descent requires two parameters:

- Learning Rate: Used to limit the amount each weight is corrected each time it is updated.
- Epochs: The number of times to run through the training data while updating the weight.

These, along with the training data will be the arguments to the function.

There are 3 loops we need to perform in the function:

- Loop over each epoch.
- Loop over each row in the training data for an epoch.
- Loop over each weight and update it for a row in an epoch.

Each weight gets updated for each row in the training data, each epoch.

Weights are updated based on the error the model made. The error is calculated as the difference between the expected output value and the prediction made with the candidate weights.

There is one weight for each input attribute, and these are updated in a consistent way, for example:

>w(t+1)= w(t) + learning_rate * (expected(t) - predicted(t)) * x(t)

The bias is updated in a similar way, except without an input as it is not associated with a specific input value:

>bias(t+1) = bias(t) + learning_rate * (expected(t) - predicted(t))

**Now, put all this together**. 

**Create a function named `train_weights()` that calculates weight values for a training dataset using stochastic gradient descent!**


## Exercise 3 - kNN implementation with Python

Given the follwing dataset:

```python
# test predictions
dataset = [[2.7810836,2.550537003,0],
	[1.465489372,2.362125076,0],
	[3.396561688,4.400293529,0],
	[1.38807019,1.850220317,0],
	[3.06407232,3.005305973,0],
	[7.627531214,2.759262235,1],
	[5.332441248,2.088626775,1],
	[8.675418651,-0.242068655,1],
	[7.673756466,3.508563011,1]]
```

The dataset contains 9 points (rows). Each point ist defined by 3 value: x1 and x2 and the class (0|1), sample [x1,x2,class].

To which class 0 or 1 does the follwoing data point `[6.922596716,1.77106367]` belong?

- Implement the kNN algorithm as a python function `knn(data, point, k=5)` and return the class to which this point belongs!
   - extract x1, x2 and class from given data by using slices over lists
   - calculate distances for whole dataset by using distance fkt from exercise 2
   - find the k nearest neighbours (k=5)
   - return the most common class in our k list

```python
def knn(data, point, k=5):
  # extract x1, x2 and class from given data by using slices over lists

  # calculate distances for whole dataset by using distance fkt from exercise 2
  
  # find the k nearest neighbours (k=5)

  # return the most common class in our k list
  
```



