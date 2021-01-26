# for FILE in build/contracts/*; do web3j generate truffle generate --truffle-json=$FILE --outputDir=./target/classes --package=zapprotocol.jzap.wrappers; done



generateWrapper(){
    for FILE in build/contracts/*
    do
    fbname=$(basename "$FILE" | cut -d. -f1)
    if (ls ./target/classes/zapprotocol/jzap/wrappers |  grep -q  "$fbname.java")
    then
        echo "Already exists"
    else
        web3j generate truffle generate --truffle-json=$FILE --outputDir=./target/classes --package=zapprotocol.jzap.wrappers
    fi
    done
}

generateWrapper