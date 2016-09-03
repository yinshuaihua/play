#! /bin/bash

echo "Ready to uploading to the server..."

scp ./target/universal/yinshuaihua-1.0-SNAPSHOT.zip root@www.guosim.com:/www2/

echo "Uploaded"
