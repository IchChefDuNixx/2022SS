_Exercise assignment for the course [Introduction to AI (partII)](https://inf-git.fh-rosenheim.de/aai-ai2/hsro-aai-ai2-github-io) in the [Bachelor of AAI](https://www.th-rosenheim.de/en/technology/computer-science-mathematics/applied-artificial-intelligence-bachelors-degree) at [Rosenheim University of Applied Sciences](http://www.th-rosenheim.de)_


# 03 - Classifier Eavluation

For this exercise you can find some hints within the provided Jupyter Notebooks.

**Solution is provided within the branch "musterloesung".**

## Exercise 1 -  Evaluation hand made and with Python

Let's say we have the follwoing distribution: TP = 30, TN = 930, FP = 30, FN = 10

#### a)

Please calcuate on paper:
- Precision
- Recall
- Accuracy
- F1-Score
- MCC

#### b)

Please validate your values by writing a Python programm.

## Exercise 2 - Evaluation in Python

What is the precision, recall, accuracy and f1_score of the IRIS dataset of [exercise 2](https://inf-git.fh-rosenheim.de/aai-ai2/02_exercise)?

## Exercise 3 - Linear regression
 
Can you write a Python programm doing a linear regression using on the following X and Y values?

```python
# imports
import numpy as np
import matplotlib.pyplot as plt

# generate random data-set
np.random.seed(0)
X = np.random.rand(100, 1)
Y = -1 + 4.5 * X + np.random.rand(100, 1)

```
