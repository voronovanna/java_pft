package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

public class GithubTests {

  @Test
  public void testCommits(){
    Github github = new RtGithub("56919b5756ffad0fa55c88fe910b4a6528577632");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("voronovanna", "java_pft")).commits();

    for (RepoCommit commit: commits.iterate(new ImmutableMap.Builder<String, String>().build())){
      System.out.println(commit);
    }
  }
}
