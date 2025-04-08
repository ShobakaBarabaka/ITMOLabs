import matplotlib.pyplot as plt
import pandas as pd

df = pd.read_excel("data4.xlsx")
df.boxplot(column=['<OPEN>','<HIGH>','<LOW>','<CLOSE>'])
plt.show()

