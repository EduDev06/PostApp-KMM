
import Foundation
import Shared

extension PostScreen {
    @MainActor class PostViewModel: ObservableObject {
        private let getPostsUseCase = GetPostsUseCase.init()
        private let randomColorUseCase = RandomBackgroundColorUseCase.init()
        
        @Published private(set) var posts:[Post] = []
        
        func getPosts() async {
            do {
                let posts = try await getPostsUseCase.invoke()
                self.posts = self.posts + posts
            } catch {
                print(error.localizedDescription)
            }
        }
        
        func randomColor() -> String {
            return randomColorUseCase.invoke()
        }
    }
}

