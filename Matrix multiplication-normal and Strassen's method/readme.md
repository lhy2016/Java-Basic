<h3>Introduction</h3>
<p>This project implements matrix multiplication in Java by using regular matrix multiplication algorithm and Schönhage–Strassen's algorithm. Two input Matrices are generated with random numbers. In my program, I used 0-9 digits. The running time of these two algorithms (theoretical or actual) is being compared.
</p>
<h3>Program test cases and output</h3>
<b>Test Case 1:</b>
<code>
<pre>
Please enter the size of matrix (must be power of 2):
<b>4</b>
Matrix 1:
0 0 1 4 
1 8 8 4 
0 2 2 2 
2 3 0 7 
<br />
Matrix 2:
3 1 3 3 
1 2 3 9 
5 8 2 8 
5 0 6 3 
<br />
<b>Regular product:</b>
25 8 26 20 
71 81 67 151 
22 20 22 40 
44 8 57 54 
<br />
Running time: <b>24468 ns</b>
<br />
<b>Strassen product:</b>
25 8 26 20 
71 81 67 151 
22 20 22 40 
44 8 57 54 

Running time:<b>535950 ns</b>
</pre>
</code>
<b>Test Case 2:</b>
<code>
<pre>
Please enter the size of matrix (must be power of 2):
<b>16</b>
Matrix 1:
5 1 8 1 9 4 7 3 3 4 8 5 9 6 7 8 
7 2 8 5 5 2 7 1 8 8 3 7 9 4 6 1 
9 9 9 5 9 0 2 5 1 3 5 9 6 5 5 0 
4 8 3 5 5 1 8 7 9 6 0 2 9 9 7 7 
4 8 1 9 3 8 9 8 8 8 8 1 3 3 0 2 
4 0 6 1 8 4 6 2 9 8 9 4 5 0 4 4 
5 5 0 5 1 1 9 8 4 6 0 0 9 9 8 9 
9 0 5 5 3 6 2 0 1 8 7 4 9 0 7 4 
4 4 5 4 5 1 8 4 7 3 3 9 1 9 5 7 
7 3 3 7 1 5 8 8 2 2 5 8 2 0 2 7 
6 5 5 1 8 2 5 4 4 8 8 0 1 8 7 8 
2 6 1 6 6 5 8 7 3 9 0 6 5 4 7 7 
7 0 8 0 3 5 4 4 3 0 2 3 8 8 0 9 
1 3 0 9 8 7 8 7 4 1 4 5 2 0 7 2 
5 9 6 4 6 6 9 1 2 9 4 0 1 0 7 6 
0 2 5 2 2 6 8 8 7 7 6 8 6 3 4 1 

Matrix 2:
1 7 6 2 6 6 6 9 2 3 4 1 5 6 6 6 
2 3 9 6 2 8 6 0 2 4 7 7 0 5 7 6 
6 9 5 9 3 9 4 8 0 8 0 2 2 7 0 1 
9 7 1 6 2 6 9 6 5 4 7 9 6 3 1 8 
8 7 1 7 2 1 7 7 8 3 2 3 8 2 9 2 
2 6 6 3 5 4 5 1 1 4 0 5 2 6 3 4 
8 3 8 9 9 3 4 9 8 4 5 7 4 1 2 4 
2 2 0 0 5 2 7 7 7 8 1 2 0 9 8 4 
2 7 1 2 9 7 8 7 2 6 9 2 6 4 2 1 
5 1 6 9 1 6 9 2 6 3 6 3 6 8 0 4 
8 2 4 5 4 8 2 3 5 5 7 7 4 4 4 2 
9 2 6 9 4 6 2 8 8 9 2 7 1 7 0 5 
8 6 3 1 4 1 7 6 8 5 1 9 8 3 9 3 
1 1 2 7 5 4 6 0 2 3 7 6 4 5 4 5 
1 5 0 6 7 1 8 7 5 6 1 7 0 5 2 4 
5 6 6 6 8 6 0 4 3 1 4 3 7 4 0 8 

<b>Regular product:</b>
466 425 345 500 436 395 450 494 423 410 297 438 386 405 326 335 
436 410 329 477 394 403 502 501 396 416 325 418 363 399 271 312 
420 389 331 470 322 412 470 470 384 426 293 414 294 421 353 334 
392 406 335 469 462 397 553 469 419 406 392 456 379 420 354 388 
401 351 354 418 387 430 503 394 377 376 404 425 331 400 309 352 
403 362 291 414 365 370 408 430 358 356 296 333 344 348 244 244 
330 332 298 397 429 319 476 406 383 333 333 416 332 371 305 378 
369 356 291 370 311 337 399 391 325 320 233 362 315 350 233 291 
383 344 318 484 416 395 412 441 360 383 343 388 302 379 233 341 
371 317 316 370 360 356 345 420 340 348 261 351 250 355 220 335 
346 349 318 467 387 394 440 386 340 333 347 355 334 390 287 326 
401 346 335 472 388 350 486 424 424 373 312 427 321 404 282 377 
295 333 270 319 344 306 302 352 250 290 205 281 289 315 242 266 
367 321 230 361 334 275 406 398 368 337 248 379 250 301 257 291 
355 359 370 467 346 383 427 376 320 313 301 364 289 353 238 323 
389 304 298 409 370 354 421 413 383 411 278 386 265 392 244 269 

Running time: <b>554009 ns</b>

<b>Strassen product:</b>
466 425 345 500 436 395 450 494 423 410 297 438 386 405 326 335 
436 410 329 477 394 403 502 501 396 416 325 418 363 399 271 312 
420 389 331 470 322 412 470 470 384 426 293 414 294 421 353 334 
392 406 335 469 462 397 553 469 419 406 392 456 379 420 354 388 
401 351 354 418 387 430 503 394 377 376 404 425 331 400 309 352 
403 362 291 414 365 370 408 430 358 356 296 333 344 348 244 244 
330 332 298 397 429 319 476 406 383 333 333 416 332 371 305 378 
369 356 291 370 311 337 399 391 325 320 233 362 315 350 233 291 
383 344 318 484 416 395 412 441 360 383 343 388 302 379 233 341 
371 317 316 370 360 356 345 420 340 348 261 351 250 355 220 335 
346 349 318 467 387 394 440 386 340 333 347 355 334 390 287 326 
401 346 335 472 388 350 486 424 424 373 312 427 321 404 282 377 
295 333 270 319 344 306 302 352 250 290 205 281 289 315 242 266 
367 321 230 361 334 275 406 398 368 337 248 379 250 301 257 291 
355 359 370 467 346 383 427 376 320 313 301 364 289 353 238 323 
389 304 298 409 370 354 421 413 383 411 278 386 265 392 244 269 

Running time:<b>8576654 ns</b></pre></code>
<h3>Theoretical runnning time analysis</h3>
<b style = 'margin-bottom:20px'>Regular multiplication algorithm:</b> 

<img src = "https://lh6.googleusercontent.com/fi8L5ejDjvjRi1n_cYixFK9rxGn2UcXeAdiP622V53VMLdipsD-bVU00rqv9ENZ6CnRKkOyDRngW45UaRaxcagj6LFVRHUUFb9z3BFXNPMSgpMrn8q_UnrBfJYg5xpgEU3W0QGzX" height="200">
<p>Analysis: to walk through all elements in result matrix takes O(n^2) time, for each element, to compute the value of it takes O(n) time. Therefore, the total running time is O(n^2*n) = <b>O(n^3)</b>.</p>
<p>For Strassen’s algorithm, product of two matrices can be computed in general as follows:</p>
<img src = "https://lh5.googleusercontent.com/HRt7rsyr56Onbt9dGoWCezaaS_2quaxYDHpdlQKdueAVgh6ZW44Wt50TZFBIZuJ02nkybhL9ZUeaOMutc477U7JYfE4l6s3Tmaoo0u0R1XZyfbNJKabm5CAc894scPEKUKwRQdSz" height = "280">
<p>For 2x2 matrices, it only has <b>7</b> multiplications, therefore, the running time of Strassen's algorithm is:</p>



