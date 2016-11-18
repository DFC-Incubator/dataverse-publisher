#!/usr/bin/env bash
docker build -t diceunc/dataverse-publisher:1.0.0.0 .
docker push diceunc/dataverse-publisher:1.0.0.0