import React, { useEffect, useState } from 'react';
import GitClient from './GitClient';

function App() {
  const [repos, setRepos] = useState([]);
  const gitClient = new GitClient();

  useEffect(() => {
    gitClient.getRepositories('techiesyed').then(data => {
      setRepos(data);
    });
  }, []);

  return (
    <div>
      <h2>GitHub Repositories</h2>
      <ul>
        {repos.map(repo => <li key={repo}>{repo}</li>)}
      </ul>
    </div>
  );
}

export default App;
