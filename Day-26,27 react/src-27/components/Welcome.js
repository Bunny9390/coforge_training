function Welcome() {

    const today = new Date().toLocaleDateString();

    return(
        <div>
            <h1>Welcome to React</h1>
            <h2>Engu Bunny</h2>
            <h3>{today}</h3>
        </div>
    );
}

export default Welcome;