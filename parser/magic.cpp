#include<bits/stdc++.h>

using namespace std;

int main(){
    freopen("grammar.txt", "r", stdin);
    freopen("magic.txt", "w", stdout);
    string line;
    while(getline(cin, line)){
        cout<<"grammar.add(\""<<line<<"\");"<<endl;
    }
}
