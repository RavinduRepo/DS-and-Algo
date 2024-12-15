import matplotlib.pyplot as plt

# Data: Step sizes and corresponding execution times for different sorting algorithms
step_sizes = [1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000, 13000, 14000, 15000]

# Best case execution times (nanoseconds) for each algorithm
bubble_sort_best = [1934500, 386200, 1363500, 1525700, 5631500, 3119800, 4174700, 11981100, 9759300, 31983400, 25538000, 12533300, 22026200, 18668100, 23636600]
bubble_sort_better1_best = [3609300, 342900, 759900, 1297500, 2450400, 3016800, 5269500, 8087300, 10302300, 10357200, 28758700, 13652000, 12216800, 16026700, 18105600]
bubble_sort_better2_best = [26800, 16500, 5800, 5800, 2000, 3000, 2800, 3000, 3200, 4000, 3600, 9500, 19500, 4100, 4300]
selection_sort_best = [1876300, 699000, 1586100, 3817700, 4512700, 10308200, 14201400, 20336500, 19966800, 19575700, 23673800, 27070000, 26762300, 36927000, 48919900]
insertion_sort_best = [42100, 8000, 288000, 8500, 4400, 8900, 6200, 12700, 19800, 10300, 8800, 16100, 8500, 11900, 10300]

# Worst case execution times (nanoseconds) for each algorithm
bubble_sort_worst = [6752700, 2927700, 6785900, 13608400, 22504700, 23348300, 42498700, 58279100, 62947900, 73595400, 93320700, 89585900, 112421800, 151893200, 274804200]
bubble_sort_better1_worst = [4101300, 1143600, 2253700, 6803300, 7041700, 9461400, 21624900, 19354400, 46634400, 62371800, 52564700, 37089200, 44833600, 55178900, 61764600]
bubble_sort_better2_worst = [3712600, 1568400, 2232800, 10759300, 6204200, 10925300, 16915700, 20521500, 29006700, 67270200, 35800100, 36758500, 49797500, 77774400, 61759200]
selection_sort_worst = [7130500, 1111000, 2722400, 6447900, 5512700, 8799500, 22652000, 16686000, 27126500, 27281700, 31596100, 33297400, 56369900, 48030000, 51458700]
insertion_sort_worst = [4250200, 2806400, 4539700, 1923500, 2119700, 2963800, 7320600, 6051000, 20068700, 12233200, 11515400, 15262400, 9849800, 14938100, 17739500]

# Plotting
fig, ax = plt.subplots(figsize=(10, 6))

# Plotting best case execution times
ax.plot(step_sizes, bubble_sort_best, label="Bubble Sort (Best)", marker='o')
ax.plot(step_sizes, bubble_sort_better1_best, label="Bubble Sort Better1 (Best)", marker='o')
ax.plot(step_sizes, bubble_sort_better2_best, label="Bubble Sort Better2 (Best)", marker='o')
ax.plot(step_sizes, selection_sort_best, label="Selection Sort (Best)", marker='o')
ax.plot(step_sizes, insertion_sort_best, label="Insertion Sort (Best)", marker='o')

# Plotting worst case execution times
ax.plot(step_sizes, bubble_sort_worst, label="Bubble Sort (Worst)", marker='x', linestyle='--')
ax.plot(step_sizes, bubble_sort_better1_worst, label="Bubble Sort Better1 (Worst)", marker='x', linestyle='--')
ax.plot(step_sizes, bubble_sort_better2_worst, label="Bubble Sort Better2 (Worst)", marker='x', linestyle='--')
ax.plot(step_sizes, selection_sort_worst, label="Selection Sort (Worst)", marker='x', linestyle='--')
ax.plot(step_sizes, insertion_sort_worst, label="Insertion Sort (Worst)", marker='x', linestyle='--')

# Labels and title
ax.set_xlabel("Step Size")
ax.set_ylabel("Execution Time (Nanoseconds)")
ax.set_title("Execution Time of Sorting Algorithms (Best and Worst Case)")

# Adding legend
ax.legend()

# Show plot
plt.grid(True)
plt.tight_layout()
plt.show()
