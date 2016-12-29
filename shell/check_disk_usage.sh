#! /bin/bash

ls -la | awk '{print $9;}' | xargs du -sh | awk 'match($0, /.*G/)'