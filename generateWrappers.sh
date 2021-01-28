generateWrapper(){
    for FILE in build/contracts/*
    do
    fbname=$(basename "$FILE" | cut -d. -f1)
    if (ls ./target/classes/io/github/zapproject/jzap/wrappers |  grep -q  "$fbname.java")
    then
        echo "Already exists"
    else
        web3j generate truffle generate --truffle-json=$FILE --outputDir=./target/classes --package=io.github.zapproject.jzap.wrappers
    fi
    done
}

generateWrapper