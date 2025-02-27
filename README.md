# AES Implementation (Educational Purposes Only)

This repository contains a simplified implementation of the Advanced Encryption Standard (AES) algorithm, intended for educational purposes. **It is not a complete or secure implementation and should not be used for any production or security-sensitive applications.**

**Key Features and Limitations:**

* **Single Round Operation:** The core encryption process only performs a single round of AES operations, specifically:
    * SubBytes
    * ShiftRows
    * MixColumns
* **Key Generation:** The code generates all 10 round keys required for a full AES-128 encryption.
* **Missing AddRoundKey:** The final AddRoundKey operation after the MixColumns step is intentionally omitted for simplicity.
* **Display of Intermediate Stages:** The code is designed to display the intermediate states of the plaintext and generated keys at each step, facilitating understanding of the algorithm's transformations.
* **Educational Focus:** This implementation focuses on demonstrating the individual steps of the AES algorithm rather than providing a fully functional encryption solution.
* **Easy Setup:** You can either install the required package (if applicable, specify which one) or simply copy the source code from the `src` folder.
* **Hardcoded Input:** The plaintext and initial key are hardcoded within the source files. You will need to modify these values directly to experiment with different inputs.

**Disclaimer:**

This code is provided for educational purposes only. It is not a complete or secure implementation of AES and should not be used for any real-world encryption. Use it at your own risk.
