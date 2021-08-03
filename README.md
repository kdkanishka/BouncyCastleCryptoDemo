### Generating RSA private key
`openssl genrsa -out privatekey.pem 2048`

### Encode it in PKCS#8 format (so Java can read it with PKCS8EncodedKeySpec)
`openssl pkcs8 -topk8 -inform PEM -outform DER -in privatekey.pem -out private_key.der -nocrypt`

### Generating public key from private key
`openssl rsa -in privatekey.pem -outform PEM -pubout -out public.pem`

