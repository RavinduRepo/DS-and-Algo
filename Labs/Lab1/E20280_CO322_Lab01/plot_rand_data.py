import matplotlib.pyplot as plt
import pandas as pd

# Data
step_sizes = [1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000, 13000, 14000, 15000]
data = {
    "Step Size": step_sizes,
    "Bubble Sort": [3008300, 3457500, 5658300, 10532700, 22121300, 45220100, 37503100, 73829300, 76176800, 108769500, 122047100, 148217100, 177561000, 304866300, 270206400],
    "Bubble Sort Better1": [3054900, 5082600, 3949000, 7101300, 33218500, 27903900, 30794400, 43473700, 58703400, 82255900, 96020900, 121308800, 169240900, 217047800, 187772800],
    "Bubble Sort Better2": [3266900, 3791300, 4156300, 9205900, 16060000, 25748200, 39430200, 56526600, 98455500, 70364100, 113768000, 157508600, 142201200, 149720500, 266274400],
    "Selection Sort": [1494900, 1750700, 2126100, 3059800, 7525300, 6418600, 10845800, 10544600, 14017100, 31355100, 53419200, 28095700, 31086300, 47210600, 52092300],
    "Insertion Sort": [1708900, 695200, 3394700, 671300, 1011300, 1308000, 2152300, 2417000, 3690500, 6685800, 6587600, 5793200, 8537400, 7584900, 9707500]
}

# Create a DataFrame for easier manipulation
df = pd.DataFrame(data)

# Plot
plt.figure(figsize=(12, 8))
for column in df.columns[1:]:
    plt.plot(df["Step Size"], df[column], label=column)

# Customizing the plot
plt.title("Execution Time of Sorting Algorithms", fontsize=16)
plt.xlabel("Step Size", fontsize=14)
plt.ylabel("Execution Time (nanoseconds)", fontsize=14)
plt.legend(fontsize=12)
plt.grid(True, which="both", linestyle="--", linewidth=0.5)
plt.tight_layout()

# Show plot
plt.show()
