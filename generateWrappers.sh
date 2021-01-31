generateWrapper(){
    echo "Generating Wrappers...."
    for FILE in build/contracts/*
    do
    echo "Opening $FILE"
    fbname=$(basename "$FILE" | cut -d. -f1)
    echo "CHECKING TARGET FOLDER"
    if (ls ./target/classes/io/github/zapproject/jzap/wrappers |  grep -q  "$fbname.java")
    then
        echo "Already exists"
    else
        echo "GENERATING WRAPPER FOR $FILE"
        web3j generate truffle generate --truffle-json=$FILE --outputDir=./target/classes --package=io.github.zapproject.jzap.wrappers
    fi
    done
}

generateWrapper
