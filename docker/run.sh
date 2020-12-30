#!/usr/bin/env bash

cd $(dirname "${BASH_SOURCE[0]}")/..

set -e

docker run -p 8080:8080 springcrypto/wallet
