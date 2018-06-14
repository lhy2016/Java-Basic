# Quicksort and Optimization
<h3>Introduction</h3>
<p>This project implemented 3 variation of quicksort algorithms. The first one used last item as the pivot. The second used median as the pivot by applying randomized selection algorithm. The third one also used median as the pivot, while, it applied deterministic (Median of the medians algorithm) selection to get the median. Number of comparisons and total running time are being compared.
</p>
<h3>Test cases and result:</h3>
<p>Input size: <b>10,000</b></p>
<img src = "https://lh3.googleusercontent.com/vSdU6seO9auagPXIUQkaNyg6C8JG6ZEhDFGpEgdBXHmdbJPW-4X_9rGGRPtNchs8vuX44v7MpnX3SKkFVLNOL0OFo5AHKHWo0ghIzjZrQtJiIK9AEM61UAw2hEKy4yZV4DJxsBkL">
<p>Input size: <b>100,000</b></p>
<img src = "https://lh3.googleusercontent.com/i4AGFXpJxmkq-5_KbgvTLCPBVmOv2pP6Z8pPa0Znp0pQYQIEfyopkkhUqLaCyT-gdiCNGD_QLZd7q-bRa8CUAQ06v7kOD8os9pe9KsdhW9x1NUva3n4RZhyQkMGfvkbiXmFL7qzu">
<p>Input size: <b>1,000,000</b></p>
<img src = "https://lh4.googleusercontent.com/U317sc3TCsn1hAbn-aw8ICT5erGAK0g06DzqGCVS7R7NDN0WuOTQ8e9D394KkKaQz_HS5tC6R13lwnY3ayx8zVC1SlzB5nMCVtQbmc9u_Dj1FiOXTthhKYzsn7eQKVobAIdnXgo-">
<p>Input size: <b>10,000,000</b></p>
<img src = "https://lh6.googleusercontent.com/oWcs3ODi7JnQaLUuig9BcJ7HfvK86PNxf-Qs8Pe3H04gAkm8i0CJ1PTwZgFLH3S9F4Lw6QmFRiqrRshDbTdzg1CUZbLIOv9wHVe57zgk6OTmGJ014kb3pxxfUjigVSsFVn2C8SsI">
<p>Input size: <b>100,000,000</b></p>
<img src = "https://lh5.googleusercontent.com/bAyt4BMoPS5IeDJ5AIlbRus9ebZPDFbkrVFNUdm-zVCAH9JCgsua6oM0M55BrQCzJhPugAnPKXHKwz4SoVbCUVuL6yX_iacmd6dc0LeJNSnmsmRg_0LR0DDkWn1Z3tAuuDXRhkrn">
<p>For this case, both counters for quickSort1 and quickSort2 almost reached the maximum of the type “float” in java.  For quickSort3, both counters and running time caused overflow problem because they are <b>way too large.</b></p>
<h3>Analysis</h3>
<p><b>Quicksort1</b> is the simplest version of quicksort algorithm. For large size randomly generated array, it actually has a <b>not bad </b>performance.</p>
<p><b>Quicksort2</b> optimized Quicksort1 by using median as the pivot in each array/subarray. In order to get the median, it used <b>Randomized Selection Algorithm</b>. To use median as the pivot for each recursive call is to, theoretically,  make sure having a “good split” every time to evenly split the array, so two sub-recursion would take roughly same time to run. </p>

<p>While, at first, I implemented strict Randomized Selection Algorithm. I found even “good split” is guaranteed, it took too much time to recursively get the exact median for a large array. It never beat quickSort1.</p>
<p>Therefore, I made some optimization</p>
<img src = "https://lh3.googleusercontent.com/KOw4ya2vZt3VeToi4RVcDiu227xoo1dogYFFmmd2IjXVX4mwWXemIAm0_Qw4f7CwBnt3Mc5w_BFUDCNtlorI5HHkMyQ_wSyoHi6U37SLVb0hUmMPgQrBDmZCn-67JimGpyPJBDzq">
