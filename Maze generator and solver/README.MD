# Maze generator and solver
<h3>Introduction</h3>
     <p>This program creates random maze based on the size that the user provided. After the maze is generated, it firstly prints the the maze, then it applies BFS(Breadth First Search) and DFS(Depth First Search) algorithm on the same maze to solve it. For each algorithm, the solution path and the actual traverse order are printed. Note that the maze is designed to have only one solution path from entrance to exit, so the printed path of two algorithm should be identical.</p>
<h3>Test cases and result</h3>
<b>Maze size:4</b>
<img src = "https://lh4.googleusercontent.com/KZAsojsUsCkOZnHQhx14W-XxdoiBiPA14-ZtNmSmib2OmbfBKhfNw50IL6nAJxqwAYPsAKJxcEy7iwJoBFyIczsrhZ8qzwdUKKxC0dniXZLmhErf9NNMkX1Gy1XGmqZ9v8lbMsrc">
<img src = "https://lh4.googleusercontent.com/vmjhQU5OIz5n9r4FasCVHVESc-T8TXHSWlmhRMrUFZN8-5D-uvlmmwOIah4FSU8HRdM_z1KMApONGdodi_kwuTyM2cwHxw-N-a1rv2i3qtc5UOdB2eBygHarhSOY1J0oP47YJfRr">
<b>Maze size: 6</b>
<img src = "https://lh6.googleusercontent.com/83Q1TQb9N1cT8HRz2DK2baFYmNCBaCiJUlDnv1UyhYlCawPA6WrFN1IwogXz3XyPeeHO0da8irnZcLgvhC4-U8lH7CcpmhwuWPrQo4Jw8at_IjCeqF7_6-5hPgIFh77yYVlkVWx-">
<img src = "https://lh4.googleusercontent.com/-ptuusBTBXt6ATZCHV2JZwf8zAYfYcnvwSvNcXvs1GZ4U8SA2KTd8Ru6yEUozPyteWLMnV1TWmV90GiEArNqpjKEUs4LsxvtVZzac_9XhvBpVmuFzaQxwwpf3lIFl-nKpvvdNtL6">
<img src = "https://lh6.googleusercontent.com/Zj6M3eBZ8EBbPpGEE3l0liAHEUSzp8NW6s9T6snW3GZ1JIVHPlUQxIJZAn3KeCauKqg0lqvJgk44U21A2doDExvl9bH280TKpZvzlZFCkYevP1dlwPdj9ZcU-VyRWHjChqeuShLl">
<img src = "https://lh3.googleusercontent.com/oTLx5bG5wcgJzq_uoPGkGtUQPT-JG54bGvqPI-Fi_iIYtjRTvf25dFfmNZlTF46Ggoc6ODQyBdQWwRJ-Aqr55FS0EXoB-Aka5htP3oGyIjUUiBUQ5uPDjjoeRYJTOa3P6k7RzmG7">
<b>Maze size: 8</b>
<img src = "https://lh4.googleusercontent.com/1LfDisOv7d1m8--cd9IR87gz1OBGpyiSU8OgslgpuLlwo9DMe-lu_3nglHa5duI76t26TemlqO0G867pjbbGpl8IsTSZRFPx6GKNEkevuoyWsd0ikwzfxYAjeP2T-webR9rozqRn">
<img src = "https://lh3.googleusercontent.com/_mfgbyFkiC1dFtZV3nI9pyQ8wz3SdMkkfuMhsFoQqIbYsiQUHWdUSE84kqBUsTTgbsvnQ2fS0hbYv3jwIoVSBFZ5bFOXB_7C7xSWGTu3I2MeEIH04S2Uegmq0zzqZEF4OZHZoDjj">
